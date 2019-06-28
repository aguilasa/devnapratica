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
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ShoppingList } from "~core/entities/shopping-list/shopping-list";

import { ShoppingListService } from "~core/entities/shopping-list/shopping-list.service";

import { ItemList } from "~core/entities/item-list/item-list";
import { ItemListService } from "~core/entities/item-list/item-list.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Component({
    templateUrl: "./shopping-list-form.component.html",
    styleUrls: [
        /*{CA:COMPONENT_STYLE_URLS:START}*/
        /*{CA:COMPONENT_STYLE_URLS:END}*/
    ],
    providers: [
        ConfirmationService,
        /*{CA:COMPONENT_PROVIDERS:START}*/
        /*{CA:COMPONENT_PROVIDERS:END}*/
    ],
    /*{CA:COMPONENT_CONFIG:START}*/
    /*{CA:COMPONENT_CONFIG:END}*/
})
export class ShoppingListFormComponent implements OnInit, OnDestroy /*{CA:CLASS_INTERFACES:START}*/ /*{CA:CLASS_INTERFACES:END}*/ {
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

    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    private routeParams: any;
    private ngUnsubscribe = new Subject();

    constructor(
        /*{CA:INJECTIONS:START}*/
        /*{CA:INJECTIONS:END}*/
        private shoppingListService: ShoppingListService,
        private router: Router,
        private route: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private hotkeysService: HotkeysService,
        private itemListService: ItemListService
    ) {
        /*{CA:CONSTRUCTOR_END:START}*/
        /*{CA:CONSTRUCTOR_END:END}*/
    }

    public ngOnInit() {
        /*{CA:ON_INIT_START:START}*/
        /*{CA:ON_INIT_START:END}*/

        this.formGroup = this.getFormGroup();

        this.route.params.pipe(takeUntil(this.ngUnsubscribe)).subscribe((params: any) => this.onRouteParamsChange(params));
        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));

        this.itemsSearchFields = this.getItemsSearchFields();
        this.itemsSearchGridFields = this.getItemsSearchGridFields();

        this.setHotkeys();

        /*{CA:ON_INIT_END:START}*/
        /*{CA:ON_INIT_END:END}*/
    }

    public ngOnDestroy() {
        /*{CA:ON_DESTROY_START:START}*/
        /*{CA:ON_DESTROY_START:END}*/

        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();

        /*{CA:ON_DESTROY_END:START}*/
        /*{CA:ON_DESTROY_END:END}*/
    }

    public setHotkeys() {
        /*{CA:SET_HOTKEYS_START:START}*/
        /*{CA:SET_HOTKEYS_START:END}*/

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

        /*{CA:SET_HOTKEYS_END:START}*/
        /*{CA:SET_HOTKEYS_END:END}*/
    }

    public isNew() {
        return this.routeParams.shoppingList == "new";
    }

    public onRouteParamsChange(params: any) {
        /*{CA:ON_ROUTE_PARAMS_CHANGE_START:START}*/
        /*{CA:ON_ROUTE_PARAMS_CHANGE_START:END}*/
        this.routeParams = params;
        /*{CA:ON_ROUTE_PARAMS_CHANGE_END:START}*/
        /*{CA:ON_ROUTE_PARAMS_CHANGE_END:END}*/
    }

    public onRouteDataChange(data: any) {
        /*{CA:ON_ROUTE_DATA_CHANGE_START:START}*/
        /*{CA:ON_ROUTE_DATA_CHANGE_START:END}*/

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

        /*{CA:ON_ROUTE_DATA_CHANGE_END:START}*/
        /*{CA:ON_ROUTE_DATA_CHANGE_END:END}*/
    }

    public onCancel() {
        /*{CA:ON_CANCEL_START:START}*/
        /*{CA:ON_CANCEL_START:END}*/

        this.goBack();

        /*{CA:ON_CANCEL_END:START}*/
        /*{CA:ON_CANCEL_END:END}*/
    }

    public onSave() {
        /*{CA:ON_SAVE_START:START}*/
        /*{CA:ON_SAVE_START:END}*/

        if (!this.formGroup.valid) return this.validateAllFormFields(this.formGroup);
        this.getSaveObservable()
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe(() => {
                this.messageService.add({
                    severity: "success",
                    summary: "Registro salvo com sucesso",
                    detail: "Sucesso",
                });
                this.goBack();
            });

        /*{CA:ON_SAVE_END:START}*/
        /*{CA:ON_SAVE_END:END}*/
    }

    public onDelete() {
        /*{CA:ON_DELETE_START:START}*/
        /*{CA:ON_DELETE_START:END}*/

        this.confirmationService.confirm({
            message: "Se o registro for removido, ele não poderá ser restaurado",
            header: "Deseja remover este registro?",
            accept: () =>
                this.getDeleteObservable()
                    .pipe(takeUntil(this.ngUnsubscribe))
                    .subscribe(),
        });

        /*{CA:ON_DELETE_END:START}*/
        /*{CA:ON_DELETE_END:END}*/
    }

    public onItemsLookupRequest(value: string) {
        /*{CA:ON_ITEMS_LOOKUP_REQUEST_START:START}*/
        /*{CA:ON_ITEMS_LOOKUP_REQUEST_START:END}*/

        const filterQuery = `id eq '${value}'`;

        this.itemListService
            .list({ filterQuery, displayFields: ["id"] })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.itemsLookupSuggestions = list.contents;
            });

        /*{CA:ON_ITEMS_LOOKUP_REQUEST_END:START}*/
        /*{CA:ON_ITEMS_LOOKUP_REQUEST_END:END}*/
    }

    public onItemsSearchRequest(event: any) {
        /*{CA:ON_ITEMS_SEARCH_REQUEST_START:START}*/
        /*{CA:ON_ITEMS_SEARCH_REQUEST_START:END}*/

        const { first, rows, multiSortMeta, filterData } = event;
        const page = first / rows;
        const sort = multiSortMeta;
        const displayFields = this.itemsSearchGridFields.map(({ name }) => name);

        const filterQuery = this.itemsSearchFields
            .filter(({ name }) => filterData[name] != undefined)
            .map(({ name, type }) => {
                const value = filterData[name];

                if (typeof value == "number") return `${name} eq ${value}`;
                else if (type == FieldType.Date) return `${name} eq '${moment(value).format("YYYY-MM-DD")}'`;
                else if (type == FieldType.Time) return `${name} eq '${moment(value).format("HH:mm:ss")}'`;
                else if (type == FieldType.DateTime) return `${name} eq '${moment(value).format()}'`;
                else if (type == FieldType.Enum) return `${name} eq ${value}`;
                else if (type == FieldType.String) return `containing(lower(${name}), lower('${value}'))`;
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

        /*{CA:ON_ITEMS_SEARCH_REQUEST_END:START}*/
        /*{CA:ON_ITEMS_SEARCH_REQUEST_END:END}*/
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            description: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            items: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
        });

        /*{CA:GET_FORM_CONTROLS:START}*/
        /*{CA:GET_FORM_CONTROLS:END}*/

        return formGroup;
    }

    private getItemsSearchFields() {
        const searchFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("furb.basico.item_list_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "quantity",
                label: this.translate.instant("furb.basico.item_list_quantity"),
                type: FieldType.Double,
            }),
            new FormField({
                name: "price",
                label: this.translate.instant("furb.basico.item_list_price"),
                type: FieldType.Double,
            }),
            new FormField({
                name: "checked",
                label: this.translate.instant("furb.basico.item_list_checked"),
                type: FieldType.Boolean,
            }),
            new FormField({
                name: "note",
                label: this.translate.instant("furb.basico.item_list_note"),
                type: FieldType.String,
            }),
        ];

        /*{CA:GET_ITEMS_SEARCH_FIELDS:START}*/
        /*{CA:GET_ITEMS_SEARCH_FIELDS:END}*/

        return searchFields;
    }

    private getItemsSearchGridFields() {
        const searchGridFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("furb.basico.item_list_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "quantity",
                label: this.translate.instant("furb.basico.item_list_quantity"),
                type: FieldType.Double,
            }),
            new FormField({
                name: "price",
                label: this.translate.instant("furb.basico.item_list_price"),
                type: FieldType.Double,
            }),
            new FormField({
                name: "checked",
                label: this.translate.instant("furb.basico.item_list_checked"),
                type: FieldType.Boolean,
            }),
            new FormField({
                name: "note",
                label: this.translate.instant("furb.basico.item_list_note"),
                type: FieldType.String,
            }),
        ];

        /*{CA:GET_ITEMS_SEARCH_GRID_FIELDS:START}*/
        /*{CA:GET_ITEMS_SEARCH_GRID_FIELDS:END}*/

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
                    summary: "Sucesso",
                    detail: "Registro(s) excluído(s) com sucesso",
                });
                this.goBack();
            })
        );
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
