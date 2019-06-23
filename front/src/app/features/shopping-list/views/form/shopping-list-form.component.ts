import { Component, OnInit, OnDestroy, TemplateRef, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { HotkeysService, Hotkey } from "angular2-hotkeys";
import { MessageService } from "primeng/components/common/messageservice";
import { ConfirmationService } from "primeng/api";
import { FormBuilder, FormGroup, FormControl, Validators } from "@angular/forms";
import { TranslateService } from "@ngx-translate/core";
import { Subject } from "rxjs";
import { tap, takeUntil } from "rxjs/operators";
import * as moment from "moment";
import { FormField, FieldType } from "@seniorsistemas/angular-components";

import { ShoppingList } from "~core/entities/shopping-list/shopping-list";

import { ShoppingListService } from "~core/entities/shopping-list/shopping-list.service";

import { ItemList } from "~core/entities/item-list/item-list";
import { ItemListService } from "~core/entities/item-list/item-list.service";

@Component({
    templateUrl: "./shopping-list-form.component.html",
    styleUrls: [],
    providers: [ConfirmationService]
})
export class ShoppingListFormComponent implements OnInit, OnDestroy {
    public localeConfig: any = {};
    public permissions: any = {};
    public allPermissions: any = {};

    public formGroup: FormGroup;
    public loading: boolean;

    public mainPanelCollapsed = false;

    public itemsLookupSuggestions: ItemList[];
    public itemsSearchFields: FormField[];
    public itemsSearchGridFields: FormField[];
    public itemsSearchGridData: ItemList[];
    public itemsSearchTotalRecords: number;

    @ViewChild("customTemplate")
    public customTemplate: TemplateRef<any>;

    @ViewChild("customFormFields")
    public customFormFields: TemplateRef<any>;

    private routeParams: any;
    private ngUnsubscribe = new Subject();

    constructor(
        private shoppingListService: ShoppingListService,
        private router: Router,
        private route: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private hotkeysService: HotkeysService,
        private itemListService: ItemListService
    ) {}

    public ngOnInit() {
        this.formGroup = this.getFormGroup();

        this.route.params
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((params: any) => this.onRouteParamsChange(params));
        this.route.data
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((data: any) => this.onRouteDataChange(data));

        this.itemsSearchFields = this.getItemsSearchFields();
        this.itemsSearchGridFields = this.getItemsSearchGridFields();

        this.setHotkeys();
    }

    public ngOnDestroy() {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    }

    public setHotkeys() {
        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+x",
                () => {
                    if (this.permissions.excluir) this.onDelete();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+s",
                () => {
                    if (this.isNew() || this.permissions.editar) this.onSave();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+c",
                () => {
                    this.onCancel();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );
    }

    public isNew() {
        return this.routeParams.shoppingList == "new";
    }

    public onRouteParamsChange(params: any) {
        this.routeParams = params;
    }

    public onRouteDataChange(data: any) {
        this.localeConfig = data.localeConfig;
        this.permissions = data.allPermissions.shoppingList;
        this.allPermissions = data.allPermissions;
        if (data.entity) {
            const canEdit = this.permissions.editar;
            if (!canEdit) this.formGroup.disable();
            this.formGroup.patchValue(ShoppingList.fromDto(data.entity));
        } else {
            this.formGroup.patchValue(new ShoppingList());
        }
    }

    public onCancel() {
        this.goBack();
    }

    public onSave() {
        if (!this.formGroup.valid) return this.validateAllFormFields(this.formGroup);
        this.getSaveObservable()
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe(() => {
                this.messageService.add({
                    severity: "success",
                    summary: this.translate.instant("saved_message_title"),
                    detail: this.translate.instant("saved_message_content")
                });
                this.goBack();
            });
    }

    public onDelete() {
        this.confirmationService.confirm({
            message: this.translate.instant("delete_confirmation_message"),
            header: this.translate.instant("delete_confirmation_title"),
            accept: () =>
                this.getDeleteObservable()
                    .pipe(takeUntil(this.ngUnsubscribe))
                    .subscribe()
        });
    }

    public onItemsLookupRequest(value: string) {
        const filterQuery = `id eq '${value}'`;

        this.itemListService
            .list({ filterQuery, displayFields: ["id"] })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.itemsLookupSuggestions = list.contents;
            });
    }

    public onItemsSearchRequest(event: any) {
        const { first, rows, multiSortMeta, filterData } = event;
        const page = first / rows;
        const sort = multiSortMeta;
        const displayFields = this.itemsSearchGridFields.map(({ name }) => name);

        const filterQuery = this.itemsSearchFields
            .filter(({ name }) => filterData[name] != undefined)
            .map(({ name, type }) => {
                const value = filterData[name];

                if (typeof value == "number") return `${name} eq ${value}`;
                else if (type == FieldType.Date)
                    return `${name} eq '${moment(value).format("YYYY-MM-DD")}'`;
                else if (type == FieldType.Time)
                    return `${name} eq '${moment(value).format("HH:mm:ss")}'`;
                else if (type == FieldType.DateTime)
                    return `${name} eq '${moment(value).format()}'`;
                else if (type == FieldType.Enum) return `${name} eq ${value}`;
                else if (type == FieldType.String)
                    return `containing(lower(${name}), lower('${value}'))`;
                else return `${name} eq '${value}'`;
            })
            .join(" and ");

        this.itemListService
            .list({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.itemsSearchGridData = list.contents;
                this.itemsSearchTotalRecords = list.totalElements;
            });
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            description: [
                { value: undefined, disabled: false },
                Validators.compose([Validators.required])
            ],
            items: [
                { value: undefined, disabled: false },
                Validators.compose([Validators.required])
            ]
        });

        return formGroup;
    }

    private getItemsSearchFields() {
        const searchFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("furb.basico.item_list_id"),
                type: FieldType.String
            }),
            new FormField({
                name: "description",
                label: this.translate.instant("furb.basico.item_list_description"),
                type: FieldType.String
            }),
            new FormField({
                name: "quantity",
                label: this.translate.instant("furb.basico.item_list_quantity"),
                type: FieldType.Double
            }),
            new FormField({
                name: "unit",
                label: this.translate.instant("furb.basico.item_list_unit"),
                type: FieldType.Enum,
                placeholder: this.translate.instant("furb.basico.item_list_unit_placeholder"),
                options: [
                    { label: "UN", value: "UN" },
                    { label: "DZ", value: "DZ" },
                    { label: "ML", value: "ML" },
                    { label: "L", value: "L" },
                    { label: "KG", value: "KG" },
                    { label: "G", value: "G" },
                    { label: "CAIXA", value: "CAIXA" },
                    { label: "EMBALAGEM", value: "EMBALAGEM" },
                    { label: "GALAO", value: "GALAO" },
                    { label: "GARRAFA", value: "GARRAFA" },
                    { label: "LATA", value: "LATA" },
                    { label: "PACOTE", value: "PACOTE" }
                ]
            }),
            new FormField({
                name: "price",
                label: this.translate.instant("furb.basico.item_list_price"),
                type: FieldType.Double
            }),
            new FormField({
                name: "note",
                label: this.translate.instant("furb.basico.item_list_note"),
                type: FieldType.String
            })
        ];

        return searchFields;
    }

    private getItemsSearchGridFields() {
        const searchGridFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("furb.basico.item_list_id"),
                type: FieldType.String
            }),
            new FormField({
                name: "description",
                label: this.translate.instant("furb.basico.item_list_description"),
                type: FieldType.String
            }),
            new FormField({
                name: "quantity",
                label: this.translate.instant("furb.basico.item_list_quantity"),
                type: FieldType.Double
            }),
            new FormField({
                name: "unit",
                label: this.translate.instant("furb.basico.item_list_unit"),
                type: FieldType.Enum,
                placeholder: this.translate.instant("furb.basico.item_list_unit_placeholder"),
                options: [
                    { label: "UN", value: "UN" },
                    { label: "DZ", value: "DZ" },
                    { label: "ML", value: "ML" },
                    { label: "L", value: "L" },
                    { label: "KG", value: "KG" },
                    { label: "G", value: "G" },
                    { label: "CAIXA", value: "CAIXA" },
                    { label: "EMBALAGEM", value: "EMBALAGEM" },
                    { label: "GALAO", value: "GALAO" },
                    { label: "GARRAFA", value: "GARRAFA" },
                    { label: "LATA", value: "LATA" },
                    { label: "PACOTE", value: "PACOTE" }
                ]
            }),
            new FormField({
                name: "price",
                label: this.translate.instant("furb.basico.item_list_price"),
                type: FieldType.Double
            }),
            new FormField({
                name: "note",
                label: this.translate.instant("furb.basico.item_list_note"),
                type: FieldType.String
            })
        ];

        return searchGridFields;
    }

    private goBack() {
        const previousRoute = "../";
        this.router.navigate([previousRoute], { relativeTo: this.route.parent });
    }

    private validateAllFormFields(formGroup: FormGroup) {
        Object.keys(formGroup.controls).forEach(field => {
            const control = formGroup.get(field);
            if (control instanceof FormControl) control.markAsDirty({ onlySelf: true });
            else if (control instanceof FormGroup) this.validateAllFormFields(control);
        });
    }

    private getSaveObservable() {
        const { value } = this.formGroup;
        const shoppingListDto = ShoppingList.toDto(value);

        let observable;

        if (this.isNew()) {
            observable = this.shoppingListService.insert(shoppingListDto);
        } else {
            const id = this.routeParams.shoppingList;
            observable = this.shoppingListService.update(id, shoppingListDto);
        }

        return observable;
    }

    private getDeleteObservable() {
        return this.shoppingListService.delete(this.routeParams.shoppingList).pipe(
            tap(() => {
                this.messageService.add({
                    severity: "success",
                    summary: this.translate.instant("deleted_message_title"),
                    detail: this.translate.instant("deleted_message_content")
                });
                this.goBack();
            })
        );
    }
}
