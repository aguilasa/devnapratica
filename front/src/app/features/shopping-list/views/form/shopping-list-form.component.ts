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
import { ItemList } from "src/app/core/entities/item-list/item-list";
import { ShoppingListService } from "src/app/core/entities/shopping-list/shopping-list.service";
import { ItemListService } from "src/app/core/entities/item-list/item-list.service";
import { ShoppingList } from "src/app/core/entities/shopping-list/shopping-list";

@Component({
    templateUrl: "./shopping-list-form.component.html",
    styleUrls: [],
    providers: [ConfirmationService]
})
export class ShoppingListFormComponent implements OnInit, OnDestroy {
    public visible = false;
    public formGroup: FormGroup;
    public loading: boolean;

    public mainPanelCollapsed = false;

    public itemsLookupSuggestions: ItemList[];
    public itemsSearchFields: FormField[];
    public itemsSearchGridFields: FormField[];
    public itemsSearchGridData: ItemList[];
    public itemsSearchTotalRecords: number;
    public itemListValues = [];
    public itemListColumns = [];

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

        this.route.params.pipe(takeUntil(this.ngUnsubscribe)).subscribe((params: any) => this.onRouteParamsChange(params));
        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));

        this.itemListColumns = this.getItemListColumns();
        this.itemsSearchFields = this.getItemsSearchFields();
        this.itemsSearchGridFields = this.getItemsSearchGridFields();
    }

    public ngOnDestroy() {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    }

    public isNew() {
        return this.routeParams.shoppingList == "new";
    }

    public onRouteParamsChange(params: any) {
        this.routeParams = params;
    }

    public onRouteDataChange(data: any) {
        let tableValues = [];
        if (data.entity) {
            const canEdit = true;
            if (!canEdit) this.formGroup.disable();
            const dto: ShoppingList = ShoppingList.fromDto(data.entity.result);
            this.formGroup.patchValue(dto);
            tableValues = dto.items;
        } else {
            this.formGroup.patchValue(new ShoppingList());
        }
        this.itemListValues = tableValues;
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
                    summary: "Registro salvo com sucesso",
                    detail: "Sucesso"
                });
                this.goBack();
            });
    }

    public onDelete() {
        this.confirmationService.confirm({
            message: "Se o registro for removido, ele não poderá ser restaurado",
            header: "Deseja remover este registro?",
            accept: () =>
                this.getDeleteObservable()
                    .pipe(takeUntil(this.ngUnsubscribe))
                    .subscribe()
        });
    }

    public onItemsLookupRequest(value: string) {
        const filterQuery = `id eq '${value}'`;

        this.itemListService
            .listWithParams({ filterQuery, displayFields: ["id"] })
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
                else if (type == FieldType.Date) return `${name} eq '${moment(value).format("YYYY-MM-DD")}'`;
                else if (type == FieldType.Time) return `${name} eq '${moment(value).format("HH:mm:ss")}'`;
                else if (type == FieldType.DateTime) return `${name} eq '${moment(value).format()}'`;
                else if (type == FieldType.Enum) return `${name} eq ${value}`;
                else if (type == FieldType.String) return `containing(lower(${name}), lower('${value}'))`;
                else return `${name} eq '${value}'`;
            })
            .join(" and ");

        this.itemListService
            .listWithParams({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.itemsSearchGridData = list.contents;
                this.itemsSearchTotalRecords = list.totalElements;
            });
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            description: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            items: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])]
        });
        return formGroup;
    }

    private getItemsSearchFields() {
        const searchFields = [
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

        return searchFields;
    }

    private getItemsSearchGridFields() {
        const searchGridFields = [
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

    // private getSaveObservable() {
    //     const { value } = this.formGroup;
    //     const shoppingListDto = ShoppingList.toDto(value);

    //     let observable;

    //     if (this.isNew()) {
    //         observable = this.shoppingListService.insert(shoppingListDto);
    //     } else {
    //         const id = this.routeParams.shoppingList;
    //         observable = this.shoppingListService.update(id, shoppingListDto);
    //     }

    //     return observable;
    // }

    private getSaveObservable() {
        const { value } = this.formGroup;
        const shoppingListDto = ShoppingList.toDto(value);

        if (!this.isNew()) {
            shoppingListDto.id = this.routeParams.shoppingList;
        }

        const observable = this.shoppingListService.persistShoppingList(shoppingListDto);

        return observable;
    }

    private getDeleteObservable() {
        return this.shoppingListService.delete(this.routeParams.shoppingList).pipe(
            tap(() => {
                this.messageService.add({
                    severity: "success",
                    summary: "Sucesso",
                    detail: "Registro(s) excluído(s) com sucesso"
                });
                this.goBack();
            })
        );
    }

    private getItemListColumns() {
        const gridColumns = [
            { field: "product", subfield: "description", header: "Produto" },
            { field: "quantity", header: "Quantidade" },
            { field: "price", header: "Preço" },
            { field: "checked", header: "Checado" }
        ];

        return gridColumns;
    }

    public getRowData(rowData: any, column: any) {
        return column.subfield ? rowData[column.field][column.subfield] : rowData[column.field];
    }

    public addItem() {
        this.visible = true;
    }

    public close() {
        this.visible = false;
    }
}
