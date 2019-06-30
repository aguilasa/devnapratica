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
import { ItemList } from "src/app/core/entities/item-list/item-list";
import { ItemListService } from "src/app/core/entities/item-list/item-list.service";

@Component({
    templateUrl: "./item-list-list.component.html",
    styleUrls: [],
    providers: [ConfirmationService]
})
export class ItemListListComponent implements OnInit, OnDestroy {
    public allPermissions: any = {};
    public permissions: any = {};
    public localeConfig: any = {};

    public currentListParams: ListParams = { page: 0, size: 10, sort: [], filterData: {} };
    public gridData: ItemList[];
    public gridColumns: any[];
    public showLoader: boolean;
    public totalRecords: number;
    public selection: ItemList[];

    public filterFields: FormField[];
    public filterFormGroup: FormGroup;
    public filtersPanelCollapsed = true;
    public searchTokens: IToken[] = [];
    public serverError: boolean = false;

    @ViewChild("itemListTable")
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

    private ngUnsubscribe = new Subject();

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private itemListService: ItemListService,
        private confirmationService: ConfirmationService,
        private translate: TranslateService,
        private messageService: MessageService,
        private hotkeysService: HotkeysService,
        private formBuilder: FormBuilder
    ) {}

    public ngOnInit() {
        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));

        this.filterFormGroup = this.formBuilder.group({
            id: [undefined, Validators.compose([])],
            quantity: [undefined, Validators.compose([])],
            price: [undefined, Validators.compose([])],
            checked: [undefined, Validators.compose([])],
            note: [undefined, Validators.compose([])]
        });

        this.setShowLoader();
        this.gridColumns = this.getGridColumns();
        this.filterFields = this.getFilterFields();
    }

    private async setShowLoader() {
        this.showLoader = true;
    }

    public ngOnDestroy() {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    }

    public onRouteDataChange(data: any) {}

    // Verifica se o objeto possui um valor que foi alterado para "" (String vazia) ao inves de null ou undefined
    private hasEmpty(target: any) {
        if (Object.keys(target).filter(key => target[key] === "").length > 0) return true;
    }

    public onSearch() {
        const filterData = this.filterFormGroup.getRawValue();

        if (this.hasEmpty(filterData)) {
            this.filtersPanelCollapsed = true;
            return this.validateAllFormFields(this.filterFormGroup);
        } else {
            this.filtersPanelCollapsed = true;
            this.resetGrid({ filterData });
        }
    }

    public onClear() {
        this.filterFormGroup.reset();
        const filterData = this.filterFormGroup.getRawValue();
        this.resetGrid({ filterData });
    }

    public onRemoveToken(token: IToken) {
        this.filterFormGroup.get(token.id).setValue(undefined);
        const filterData = this.filterFormGroup.getRawValue();
        this.resetGrid({ filterData });
    }

    public onGridChange(event: LazyLoadEvent) {
        const size = event.rows;
        const page = event.first / size;
        const sort = event.multiSortMeta;

        return this.updateGrid({ page, size, sort });
    }

    public onAdd() {
        this.router.navigate(["new"], { relativeTo: this.route });
    }

    public onEdit() {
        this.router.navigate([this.selection[0].id], { relativeTo: this.route });
    }

    public onDelete() {
        this.confirmationService.confirm({
            message: "Se o registro for removido, ele não poderá ser restaurado",
            header: "Deseja remover este registro?",
            accept: () => {
                forkJoin(this.selection.map(itemList => this.itemListService.delete(itemList.id)))
                    .pipe(takeUntil(this.ngUnsubscribe))
                    .subscribe(() => {
                        this.messageService.add({
                            severity: "success",
                            summary: "Sucesso",
                            detail: "Registro(s) excluído(s) com sucesso"
                        });

                        this.resetGrid();
                    });
            }
        });
    }

    private getGridColumns() {
        const gridColumns = [
            // { field: "id", header: this.translate.instant("furb.basico.item_list_id") },
            { field: "quantity", header: "Quantidade" },
            { field: "price", header: "Preço" },
            { field: "checked", header: "Marcado" },
            // { field: "note", header: "Observação" }
        ];

        return gridColumns;
    }

    private getFilterFields() {
        const filterFields = [
            new FormField({
                name: "id",
                label: "Código",
                type: FieldType.String
            }),
            new FormField({
                name: "quantity",
                label: "Quantidade",
                type: FieldType.Double
            }),
            new FormField({
                name: "price",
                label: "Preço",
                type: FieldType.Double
            }),
            new FormField({
                name: "checked",
                label: "Marcado",
                type: FieldType.Boolean
            }),
            new FormField({
                name: "note",
                label: "Observação",
                type: FieldType.String
            })
        ];

        return filterFields;
    }

    private getEnumQuery(name: string, value: any, multiple: boolean) {
        return multiple ? `(${value.map((selected: any) => `${name} eq ${selected}`).join(" or ")})` : `${name} eq ${value}`;
    }

    private updateGrid(listParams: ListParams = {}) {
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

        this.itemListService
            .listWithParams({ page, size, sort, filterQuery, displayFields })
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
}

interface ListParams {
    page?: number;
    size?: number;
    sort?: SortMeta[];
    filterData?: any;
}
