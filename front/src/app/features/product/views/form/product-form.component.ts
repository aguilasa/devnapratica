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

import { Product } from "~core/entities/product/product";

import { ProductService } from "~core/entities/product/product.service";

import { Category } from "~core/entities/category/category";
import { CategoryService } from "~core/entities/category/category.service";

import { Unit } from "~core/enums/unit";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Component({
    templateUrl: "./product-form.component.html",
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
export class ProductFormComponent implements OnInit, OnDestroy /*{CA:CLASS_INTERFACES:START}*/ /*{CA:CLASS_INTERFACES:END}*/ {
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
        { label: this.translate.instant("furb.basico.unit_pacote"), value: Unit.PACOTE },
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

    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    private routeParams: any;
    private ngUnsubscribe = new Subject();

    constructor(
        /*{CA:INJECTIONS:START}*/
        /*{CA:INJECTIONS:END}*/
        private productService: ProductService,
        private router: Router,
        private route: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private hotkeysService: HotkeysService,
        private categoryService: CategoryService
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

        this.categorySearchFields = this.getCategorySearchFields();
        this.categorySearchGridFields = this.getCategorySearchGridFields();

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
        return this.routeParams.product == "new";
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
        this.permissions = data.allPermissions.product;
        this.allPermissions = data.allPermissions;
        if (data.entity) {
            const canEdit = this.permissions.editar;
            if (!canEdit) this.formGroup.disable();
            this.formGroup.patchValue(Product.fromDto(data.entity));
        } else {
            this.formGroup.patchValue(new Product());
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

    public onCategoryLookupRequest(value: string) {
        /*{CA:ON_CATEGORY_LOOKUP_REQUEST_START:START}*/
        /*{CA:ON_CATEGORY_LOOKUP_REQUEST_START:END}*/

        const filterQuery = `id eq '${value}'`;

        this.categoryService
            .list({ filterQuery, displayFields: ["id"] })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.categoryLookupSuggestions = list.contents;
            });

        /*{CA:ON_CATEGORY_LOOKUP_REQUEST_END:START}*/
        /*{CA:ON_CATEGORY_LOOKUP_REQUEST_END:END}*/
    }

    public onCategorySearchRequest(event: any) {
        /*{CA:ON_CATEGORY_SEARCH_REQUEST_START:START}*/
        /*{CA:ON_CATEGORY_SEARCH_REQUEST_START:END}*/

        const { first, rows, multiSortMeta, filterData } = event;
        const page = first / rows;
        const sort = multiSortMeta;
        const displayFields = this.categorySearchGridFields.map(({ name }) => name);

        const filterQuery = this.categorySearchFields
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

        this.categoryService
            .list({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.categorySearchGridData = list.contents;
                this.categorySearchTotalRecords = list.totalElements;
            });

        /*{CA:ON_CATEGORY_SEARCH_REQUEST_END:START}*/
        /*{CA:ON_CATEGORY_SEARCH_REQUEST_END:END}*/
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            description: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            unit: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            category: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
        });

        /*{CA:GET_FORM_CONTROLS:START}*/
        /*{CA:GET_FORM_CONTROLS:END}*/

        return formGroup;
    }

    private getCategorySearchFields() {
        const searchFields = [
            new FormField({
                name: "id",
                label: "Código",
                type: FieldType.String,
            }),
            new FormField({
                name: "description",
                label: "Descrição da categoria",
                type: FieldType.String,
            }),
        ];

        /*{CA:GET_CATEGORY_SEARCH_FIELDS:START}*/
        /*{CA:GET_CATEGORY_SEARCH_FIELDS:END}*/

        return searchFields;
    }

    private getCategorySearchGridFields() {
        const searchGridFields = [
            new FormField({
                name: "id",
                label: "Código",
                type: FieldType.String,
            }),
            new FormField({
                name: "description",
                label: "Descrição da categoria",
                type: FieldType.String,
            }),
        ];

        /*{CA:GET_CATEGORY_SEARCH_GRID_FIELDS:START}*/
        /*{CA:GET_CATEGORY_SEARCH_GRID_FIELDS:END}*/

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
        const productDto = Product.toDto(value);

        let observable;

        if (this.isNew()) {
            observable = this.productService.insert(productDto);
        } else {
            const id = this.routeParams.product;
            observable = this.productService.update(id, productDto);
        }

        return observable;
    }

    private getDeleteObservable() {
        return this.productService.delete(this.routeParams.product).pipe(
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
