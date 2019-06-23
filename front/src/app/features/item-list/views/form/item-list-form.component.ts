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

import { ItemList } from "~core/entities/item-list/item-list";

import { ItemListService } from "~core/entities/item-list/item-list.service";

import { Category } from "~core/entities/category/category";
import { CategoryService } from "~core/entities/category/category.service";

import { Unit } from "~core/enums/unit";

@Component({
    templateUrl: "./item-list-form.component.html",
    styleUrls: [],
    providers: [ConfirmationService]
})
export class ItemListFormComponent implements OnInit, OnDestroy {
    public localeConfig: any = {};
    public permissions: any = {};
    public allPermissions: any = {};

    public formGroup: FormGroup;
    public loading: boolean;

    public mainPanelCollapsed = false;

    public unit: { label: string; value: Unit }[] = [
        { label: this.translate.instant("furb.basico.unit_un"), value: Unit.UN },
        { label: this.translate.instant("furb.basico.unit_dz"), value: Unit.DZ },
        { label: this.translate.instant("furb.basico.unit_ml"), value: Unit.ML },
        { label: this.translate.instant("furb.basico.unit_l"), value: Unit.L },
        { label: this.translate.instant("furb.basico.unit_kg"), value: Unit.KG },
        { label: this.translate.instant("furb.basico.unit_g"), value: Unit.G },
        { label: this.translate.instant("furb.basico.unit_caixa"), value: Unit.CAIXA },
        { label: this.translate.instant("furb.basico.unit_embalagem"), value: Unit.EMBALAGEM },
        { label: this.translate.instant("furb.basico.unit_galao"), value: Unit.GALAO },
        { label: this.translate.instant("furb.basico.unit_garrafa"), value: Unit.GARRAFA },
        { label: this.translate.instant("furb.basico.unit_lata"), value: Unit.LATA },
        { label: this.translate.instant("furb.basico.unit_pacote"), value: Unit.PACOTE }
    ];

    public categoryLookupSuggestions: Category[];
    public categorySearchFields: FormField[];
    public categorySearchGridFields: FormField[];
    public categorySearchGridData: Category[];
    public categorySearchTotalRecords: number;

    @ViewChild("customTemplate")
    public customTemplate: TemplateRef<any>;

    @ViewChild("customFormFields")
    public customFormFields: TemplateRef<any>;

    private routeParams: any;
    private ngUnsubscribe = new Subject();

    constructor(
        private itemListService: ItemListService,
        private router: Router,
        private route: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private hotkeysService: HotkeysService,
        private categoryService: CategoryService
    ) {}

    public ngOnInit() {
        this.formGroup = this.getFormGroup();

        this.route.params
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((params: any) => this.onRouteParamsChange(params));
        this.route.data
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((data: any) => this.onRouteDataChange(data));

        this.categorySearchFields = this.getCategorySearchFields();
        this.categorySearchGridFields = this.getCategorySearchGridFields();

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
        return this.routeParams.itemList == "new";
    }

    public onRouteParamsChange(params: any) {
        this.routeParams = params;
    }

    public onRouteDataChange(data: any) {
        this.localeConfig = data.localeConfig;
        this.permissions = data.allPermissions.itemList;
        this.allPermissions = data.allPermissions;
        if (data.entity) {
            const canEdit = this.permissions.editar;
            if (!canEdit) this.formGroup.disable();
            this.formGroup.patchValue(ItemList.fromDto(data.entity));
        } else {
            this.formGroup.patchValue(new ItemList());
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

    public onCategoryLookupRequest(value: string) {
        const filterQuery = `id eq '${value}'`;

        this.categoryService
            .list({ filterQuery, displayFields: ["id"] })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.categoryLookupSuggestions = list.contents;
            });
    }

    public onCategorySearchRequest(event: any) {
        const { first, rows, multiSortMeta, filterData } = event;
        const page = first / rows;
        const sort = multiSortMeta;
        const displayFields = this.categorySearchGridFields.map(({ name }) => name);

        const filterQuery = this.categorySearchFields
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

        this.categoryService
            .list({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.categorySearchGridData = list.contents;
                this.categorySearchTotalRecords = list.totalElements;
            });
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            description: [
                { value: undefined, disabled: false },
                Validators.compose([Validators.required])
            ],
            quantity: [
                { value: undefined, disabled: false },
                Validators.compose([Validators.required])
            ],
            unit: [
                { value: undefined, disabled: false },
                Validators.compose([Validators.required])
            ],
            price: [
                { value: undefined, disabled: false },
                Validators.compose([Validators.required])
            ],
            category: [
                { value: undefined, disabled: false },
                Validators.compose([Validators.required])
            ],
            note: [{ value: undefined, disabled: false }, Validators.compose([])]
        });

        return formGroup;
    }

    private getCategorySearchFields() {
        const searchFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("furb.basico.category_id"),
                type: FieldType.String
            }),
            new FormField({
                name: "description",
                label: this.translate.instant("furb.basico.category_description"),
                type: FieldType.String
            })
        ];

        return searchFields;
    }

    private getCategorySearchGridFields() {
        const searchGridFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("furb.basico.category_id"),
                type: FieldType.String
            }),
            new FormField({
                name: "description",
                label: this.translate.instant("furb.basico.category_description"),
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
        const itemListDto = ItemList.toDto(value);

        let observable;

        if (this.isNew()) {
            observable = this.itemListService.insert(itemListDto);
        } else {
            const id = this.routeParams.itemList;
            observable = this.itemListService.update(id, itemListDto);
        }

        return observable;
    }

    private getDeleteObservable() {
        return this.itemListService.delete(this.routeParams.itemList).pipe(
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
