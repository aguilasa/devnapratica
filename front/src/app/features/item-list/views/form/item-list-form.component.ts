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

import { ItemList } from "~core/entities/item-list/item-list";

import { ItemListService } from "~core/entities/item-list/item-list.service";

import { Product } from "~core/entities/product/product";
import { ProductService } from "~core/entities/product/product.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Component({
    templateUrl: "./item-list-form.component.html",
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
export class ItemListFormComponent implements OnInit, OnDestroy /*{CA:CLASS_INTERFACES:START}*/ /*{CA:CLASS_INTERFACES:END}*/ {
    public localeConfig: any = {};
    public permissions: any = {};
    public allPermissions: any = {};

    public formGroup: FormGroup;
    public loading: boolean;

    public mainPanelCollapsed = false;

    public productLookupSuggestions: Product[];
    public productSearchFields: FormField[];
    public productSearchGridFields: FormField[];
    public productSearchGridData: Product[];
    public productSearchTotalRecords: number;

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
        private itemListService: ItemListService,
        private router: Router,
        private route: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private hotkeysService: HotkeysService,
        private productService: ProductService
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

        this.productSearchFields = this.getProductSearchFields();
        this.productSearchGridFields = this.getProductSearchGridFields();

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
        return this.routeParams.itemList == "new";
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
        this.permissions = data.allPermissions.itemList;
        this.allPermissions = data.allPermissions;
        if (data.entity) {
            const canEdit = this.permissions.editar;
            if (!canEdit) this.formGroup.disable();
            this.formGroup.patchValue(ItemList.fromDto(data.entity));
        } else {
            this.formGroup.patchValue(new ItemList());
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
                    summary: this.translate.instant("saved_message_title"),
                    detail: this.translate.instant("saved_message_content"),
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
            message: this.translate.instant("delete_confirmation_message"),
            header: this.translate.instant("delete_confirmation_title"),
            accept: () =>
                this.getDeleteObservable()
                    .pipe(takeUntil(this.ngUnsubscribe))
                    .subscribe(),
        });

        /*{CA:ON_DELETE_END:START}*/
        /*{CA:ON_DELETE_END:END}*/
    }

    public onProductLookupRequest(value: string) {
        /*{CA:ON_PRODUCT_LOOKUP_REQUEST_START:START}*/
        /*{CA:ON_PRODUCT_LOOKUP_REQUEST_START:END}*/

        const filterQuery = `id eq '${value}'`;

        this.productService
            .list({ filterQuery, displayFields: ["id"] })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.productLookupSuggestions = list.contents;
            });

        /*{CA:ON_PRODUCT_LOOKUP_REQUEST_END:START}*/
        /*{CA:ON_PRODUCT_LOOKUP_REQUEST_END:END}*/
    }

    public onProductSearchRequest(event: any) {
        /*{CA:ON_PRODUCT_SEARCH_REQUEST_START:START}*/
        /*{CA:ON_PRODUCT_SEARCH_REQUEST_START:END}*/

        const { first, rows, multiSortMeta, filterData } = event;
        const page = first / rows;
        const sort = multiSortMeta;
        const displayFields = this.productSearchGridFields.map(({ name }) => name);

        const filterQuery = this.productSearchFields
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

        this.productService
            .list({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.productSearchGridData = list.contents;
                this.productSearchTotalRecords = list.totalElements;
            });

        /*{CA:ON_PRODUCT_SEARCH_REQUEST_END:START}*/
        /*{CA:ON_PRODUCT_SEARCH_REQUEST_END:END}*/
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            product: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            quantity: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            price: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            checked: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            note: [{ value: undefined, disabled: false }, Validators.compose([])],
        });

        /*{CA:GET_FORM_CONTROLS:START}*/
        /*{CA:GET_FORM_CONTROLS:END}*/

        return formGroup;
    }

    private getProductSearchFields() {
        const searchFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("furb.basico.product_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "description",
                label: this.translate.instant("furb.basico.product_description"),
                type: FieldType.String,
            }),
            new FormField({
                name: "unit",
                label: this.translate.instant("furb.basico.product_unit"),
                type: FieldType.Enum,
                placeholder: this.translate.instant("furb.basico.product_unit_placeholder"),
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
                    { label: "PACOTE", value: "PACOTE" },
                ],
            }),
        ];

        /*{CA:GET_PRODUCT_SEARCH_FIELDS:START}*/
        /*{CA:GET_PRODUCT_SEARCH_FIELDS:END}*/

        return searchFields;
    }

    private getProductSearchGridFields() {
        const searchGridFields = [
            new FormField({
                name: "id",
                label: this.translate.instant("furb.basico.product_id"),
                type: FieldType.String,
            }),
            new FormField({
                name: "description",
                label: this.translate.instant("furb.basico.product_description"),
                type: FieldType.String,
            }),
            new FormField({
                name: "unit",
                label: this.translate.instant("furb.basico.product_unit"),
                type: FieldType.Enum,
                placeholder: this.translate.instant("furb.basico.product_unit_placeholder"),
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
                    { label: "PACOTE", value: "PACOTE" },
                ],
            }),
        ];

        /*{CA:GET_PRODUCT_SEARCH_GRID_FIELDS:START}*/
        /*{CA:GET_PRODUCT_SEARCH_GRID_FIELDS:END}*/

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
                    detail: this.translate.instant("deleted_message_content"),
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
