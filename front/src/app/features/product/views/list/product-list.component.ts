import * as moment from "moment";
import { Component, OnInit, OnDestroy, TemplateRef, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { FormBuilder, FormGroup, FormControl, Validators } from "@angular/forms";
import { HotkeysService, Hotkey } from "angular2-hotkeys";
import { SortMeta, LazyLoadEvent, ConfirmationService } from "primeng/components/common/api";
import { MessageService } from "primeng/components/common/messageservice";
import { Table } from "primeng/table";
import { TranslateService } from "@ngx-translate/core";
import { Subject, forkJoin, of } from "rxjs";
import { takeUntil, finalize, catchError, map } from "rxjs/operators";
import { FormField, FieldType, IToken } from "@seniorsistemas/angular-components";
import { FiltersStorageService } from "~shared/storage/filters-storage.service";
/*{CA:EXTERNAL_IMPORTS:START}*/
/*{CA:EXTERNAL_IMPORTS:END}*/

import { Product } from "~core/entities/product/product";
import { ProductService } from "~core/entities/product/product.service";

import { Unit } from "~core/enums/unit";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Component({
    templateUrl: "./product-list.component.html",
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
export class ProductListComponent implements OnInit, OnDestroy /*{CA:CLASS_INTERFACES:START}*/ /*{CA:CLASS_INTERFACES:END}*/ {
    public allPermissions: any = {};
    public permissions: any = {};
    public localeConfig: any = {};

    public currentListParams: ListParams = { page: 0, size: 10, sort: [], filterData: {} };
    public gridData: Product[];
    public gridColumns: any[];
    public showLoader: boolean;
    public totalRecords: number;
    public selection: Product[];

    public filterFields: FormField[];
    public filterFormGroup: FormGroup;
    public filtersPanelCollapsed = true;
    public searchTokens: IToken[] = [];
    public serverError: boolean = false;
    public filtersLoaded = false;

    @ViewChild("productTable")
    public table: Table;

    @ViewChild("customTemplate")
    public customTemplate: TemplateRef<any>;

    @ViewChild("customFilterFields")
    public customFilterFields: TemplateRef<any>;

    @ViewChild("customGridColgroup")
    public customGridColgroup: TemplateRef<any>;

    @ViewChild("customGridHeader")
    public customGridHeader: TemplateRef<any>;

    @ViewChild("customGridBody")
    public customGridBody: TemplateRef<any>;

    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    private ngUnsubscribe = new Subject();

    constructor(
        /*{CA:INJECTIONS:START}*/
        /*{CA:INJECTIONS:END}*/
        private router: Router,
        private route: ActivatedRoute,
        private productService: ProductService,
        private confirmationService: ConfirmationService,
        private translate: TranslateService,
        private messageService: MessageService,
        private hotkeysService: HotkeysService,
        private formBuilder: FormBuilder,
        private filtersStorageService: FiltersStorageService
    ) {
        /*{CA:CONSTRUCTOR_END:START}*/
        /*{CA:CONSTRUCTOR_END:END}*/
    }

    public ngOnInit() {
        /*{CA:ON_INIT_START:START}*/
        /*{CA:ON_INIT_START:END}*/

        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));

        this.filterFormGroup = this.formBuilder.group({
            id: [undefined, Validators.compose([])],
            description: [undefined, Validators.compose([])],
            unit: [undefined, Validators.compose([])],
        });

        this.setStorageFiltersIntoForm(this.filterFormGroup);
        this.gridColumns = this.getGridColumns();
        this.filterFields = this.getFilterFields();

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
                "alt+shift+e",
                () => {
                    if (this.selection && this.selection.length === 1) {
                        this.onEdit();
                    }
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+x",
                () => {
                    if (this.selection && this.selection.length && this.permissions.excluir) {
                        this.onDelete();
                    }
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        this.hotkeysService.add(
            new Hotkey(
                "alt+shift+n",
                () => {
                    if (this.permissions.incluir) this.onAdd();
                    return false;
                },
                ["INPUT", "SELECT", "TEXTAREA"]
            )
        );

        /*{CA:SET_HOTKEYS_END:START}*/
        /*{CA:SET_HOTKEYS_END:END}*/
    }

    public onRouteDataChange(data: any) {
        /*{CA:ON_ROUTE_DATA_CHANGE_START:START}*/
        /*{CA:ON_ROUTE_DATA_CHANGE_START:END}*/

        this.allPermissions = data.allPermissions;
        this.permissions = data.allPermissions.product;
        this.localeConfig = data.localeConfig;

        /*{CA:ON_ROUTE_DATA_CHANGE_END:START}*/
        /*{CA:ON_ROUTE_DATA_CHANGE_END:END}*/
    }

    // Verifica se o objeto possui um valor que foi alterado para "" (String vazia) ao inves de null ou undefined
    private hasEmpty(target: any) {
        if (Object.keys(target).filter(key => target[key] === "").length > 0) return true;
    }

    public onSearch() {
        /*{CA:ON_SEARCH_START:START}*/
        /*{CA:ON_SEARCH_START:END}*/

        const filterData = this.filterFormGroup.getRawValue();

        if (this.hasEmpty(filterData)) {
            this.filtersPanelCollapsed = true;
            return this.validateAllFormFields(this.filterFormGroup);
        } else {
            this.filtersPanelCollapsed = true;
            this.resetGrid({ filterData });
            this.filtersStorageService.storeFilters(this.constructor.name, filterData);
        }

        /*{CA:ON_SEARCH_END:START}*/
        /*{CA:ON_SEARCH_END:END}*/
    }

    public onClear() {
        /*{CA:ON_CLEAR_START:START}*/
        /*{CA:ON_CLEAR_START:END}*/

        this.filterFormGroup.reset();
        const filterData = this.filterFormGroup.getRawValue();
        this.resetGrid({ filterData });

        /*{CA:ON_CLEAR_END:START}*/
        /*{CA:ON_CLEAR_END:END}*/
    }

    public onRemoveToken(token: IToken) {
        /*{CA:ON_REMOVE_TOKEN_START:START}*/
        /*{CA:ON_REMOVE_TOKEN_START:END}*/

        this.filterFormGroup.get(token.id).setValue(undefined);
        const filterData = this.filterFormGroup.getRawValue();
        this.resetGrid({ filterData });
        this.filtersStorageService.storeFilters(this.constructor.name, filterData);

        /*{CA:ON_REMOVE_TOKEN_END:START}*/
        /*{CA:ON_REMOVE_TOKEN_END:END}*/
    }

    public onGridChange(event: LazyLoadEvent) {
        /*{CA:ON_GRID_CHANGE_START:START}*/
        /*{CA:ON_GRID_CHANGE_START:END}*/

        const size = event.rows;
        const page = event.first / size;
        const sort = event.multiSortMeta;

        return this.updateGrid({ page, size, sort });

        /*{CA:ON_GRID_CHANGE_END:START}*/
        /*{CA:ON_GRID_CHANGE_END:END}*/
    }

    public onAdd() {
        /*{CA:ON_ADD_START:START}*/
        /*{CA:ON_ADD_START:END}*/

        this.router.navigate(["new"], { relativeTo: this.route });

        /*{CA:ON_ADD_END:START}*/
        /*{CA:ON_ADD_END:END}*/
    }

    public onEdit() {
        /*{CA:ON_EDIT_START:START}*/
        /*{CA:ON_EDIT_START:END}*/

        this.router.navigate([this.selection[0].id], { relativeTo: this.route });

        /*{CA:ON_EDIT_END:START}*/
        /*{CA:ON_EDIT_END:END}*/
    }

    public onDelete() {
        /*{CA:ON_DELETE_START:START}*/
        /*{CA:ON_DELETE_START:END}*/

        this.confirmationService.confirm({
            message: "Se o registro for removido, ele não poderá ser restaurado",
            header: "Deseja remover este registro?",
            accept: () => {
                forkJoin(this.selection.map(product => this.productService.delete(product.id)))
                    .pipe(takeUntil(this.ngUnsubscribe))
                    .subscribe(() => {
                        this.messageService.add({
                            severity: "success",
                            summary: "Sucesso",
                            detail: "Registro(s) excluído(s) com sucesso",
                        });

                        this.resetGrid();
                    });
            },
        });

        /*{CA:ON_DELETE_END:START}*/
        /*{CA:ON_DELETE_END:END}*/
    }

    private getGridColumns() {
        const gridColumns = [
            { field: "id", header: this.translate.instant("furb.basico.product_id") },
            { field: "description", header: this.translate.instant("furb.basico.product_description") },
            { field: "unit", header: this.translate.instant("furb.basico.product_unit") },
        ];

        /*{CA:GET_GRID_COLUMNS:START}*/
        /*{CA:GET_GRID_COLUMNS:END}*/

        return gridColumns;
    }

    private getFilterFields() {
        const filterFields = [
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
                ],
                multiple: false,
            }),
        ];

        /*{CA:GET_SEARCH_FIELDS:START}*/
        /*{CA:GET_SEARCH_FIELDS:END}*/

        return filterFields;
    }

    private async setStorageFiltersIntoForm(form: FormGroup) {
        this.showLoader = true;
        const filters = await this.filtersStorageService.getFilters(this.constructor.name);

        Object.keys(form.controls).forEach(field => form.get(field).setValue(filters[field]));

        this.filtersLoaded = true;
        const filterData = this.filterFormGroup.getRawValue();
        this.resetGrid({ filterData });

        /*{CA:GET_FILTER_FORM_GROUP:START}*/
        /*{CA:GET_FILTER_FORM_GROUP:END}*/
    }

    private getEnumQuery(name: string, value: any, multiple: boolean) {
        return multiple ? `(${value.map((selected: any) => `${name} eq ${selected}`).join(" or ")})` : `${name} eq ${value}`;
    }

    private updateGrid(listParams: ListParams = {}) {
        if (!this.filtersLoaded) return;

        this.showLoader = true;
        this.currentListParams = { ...this.currentListParams, ...listParams };
        const { page, size, sort, filterData } = this.currentListParams;

        this.searchTokens = this.filterFields
            .filter(({ name }) => filterData[name] != undefined && filterData[name] !== "")
            .map(({ name, label, type }) => {
                const value = filterData[name];
                let labelValue = value;

                if (type == FieldType.Date) labelValue = moment(value).format("L");
                else if (type == FieldType.Time) labelValue = moment(value).format("LTS");
                else if (type == FieldType.DateTime) labelValue = moment(value).format("L LTS");
                else if (type == FieldType.Lookup) labelValue = value.id;

                return { id: name, label: `${label}: ${labelValue}` };
            });

        const filterQuery = this.filterFields
            .filter(({ name }) => filterData[name] != undefined)
            .map(({ name, type, multiple }) => {
                const value = filterData[name];

                if (typeof value == "number") return `${name} eq ${value}`;
                else if (type == FieldType.Date) return `${name} eq '${moment(value).format("YYYY-MM-DD")}'`;
                else if (type == FieldType.Time) return `${name} eq '${moment(value).format("HH:mm:ss")}'`;
                else if (type == FieldType.DateTime) return `${name} eq '${moment(value).format()}'`;
                else if (type == FieldType.String) return `containing(lower(${name}), lower('${value}'))`;
                else if (type == FieldType.Enum) return this.getEnumQuery(name, value, multiple);
                else return `${name} eq '${value}'`;
            })
            .join(" and ");

        const displayFields = this.gridColumns.map(column => column.field);

        this.productService
            .list({ page, size, sort, filterQuery, displayFields })
            .pipe(
                takeUntil(this.ngUnsubscribe),
                catchError((err: any) => {
                    if (err.status >= 500 && err.status < 600) this.serverError = true;
                    throw err;
                }),
                finalize(() => {
                    this.showLoader = false;
                })
            )
            .subscribe((list: any) => {
                this.selection = [];
                this.gridData = list.contents;
                this.totalRecords = list.totalElements;
                this.serverError = false;
            });
    }

    private resetGrid(listParams?: ListParams) {
        if (listParams) this.currentListParams = { ...this.currentListParams, ...listParams };
        this.currentListParams = { ...this.currentListParams, page: 0, sort: [] };
        this.table.reset();
    }

    private validateAllFormFields(formGroup: FormGroup) {
        Object.keys(formGroup.controls).forEach(field => {
            const control = formGroup.get(field);
            if (control instanceof FormControl) control.markAsDirty({ onlySelf: true });
            else if (control instanceof FormGroup) this.validateAllFormFields(control);
        });
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

interface ListParams {
    page?: number;
    size?: number;
    sort?: SortMeta[];
    filterData?: any;
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
