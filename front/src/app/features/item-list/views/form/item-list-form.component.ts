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
import { Product } from "src/app/core/entities/product/product";
import { ItemListService } from "src/app/core/entities/item-list/item-list.service";
import { ProductService } from "src/app/core/entities/product/product.service";
import { ItemList } from "src/app/core/entities/item-list/item-list";

@Component({
    templateUrl: "./item-list-form.component.html",
    styleUrls: [],
    providers: [ConfirmationService]
})
export class ItemListFormComponent implements OnInit, OnDestroy {
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
        private productService: ProductService
    ) {}

    public ngOnInit() {
        this.formGroup = this.getFormGroup();

        this.route.params.pipe(takeUntil(this.ngUnsubscribe)).subscribe((params: any) => this.onRouteParamsChange(params));
        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));

        this.productSearchFields = this.getProductSearchFields();
        this.productSearchGridFields = this.getProductSearchGridFields();
    }

    public ngOnDestroy() {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    }

    public isNew() {
        return this.routeParams.itemList == "new";
    }

    public onRouteParamsChange(params: any) {
        this.routeParams = params;
    }

    public onRouteDataChange(data: any) {
        if (data.entity) {
            const canEdit = true;
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

    public onProductLookupRequest(value: string) {
        const filterQuery = `containing(lower(description), lower('${value}'))`;

        this.productService
            .listWithParams({ filterQuery, displayFields: ["description"] })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.productLookupSuggestions = list.contents;
            });
    }

    public onProductSearchRequest(event: any) {
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
            .listWithParams({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.productSearchGridData = list.contents;
                this.productSearchTotalRecords = list.totalElements;
            });
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            product: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            quantity: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            price: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            checked: [{ value: undefined, disabled: false }, Validators.compose([])],
            note: [{ value: undefined, disabled: false }, Validators.compose([])]
        });

        return formGroup;
    }

    private getProductSearchFields() {
        const searchFields = [
            // new FormField({
            //     name: "id",
            //     label: "Código",
            //     type: FieldType.String
            // }),
            new FormField({
                name: "description",
                label: "Descrição",
                type: FieldType.String
            }),
            new FormField({
                name: "unit",
                label: "Unidade de medida",
                type: FieldType.Enum,
                placeholder: "Selecione uma unidade de medida",
                options: [
                    { label: "Unidade", value: "UN" },
                    { label: "Dúzia", value: "DZ" },
                    { label: "ml", value: "ML" },
                    { label: "l", value: "L" },
                    { label: "kg", value: "KG" },
                    { label: "g", value: "G" },
                    { label: "Caixa", value: "CAIXA" },
                    { label: "Embalagem", value: "EMBALAGEM" },
                    { label: "Galão", value: "GALAO" },
                    { label: "Garrafa", value: "GARRAFA" },
                    { label: "Lata", value: "LATA" },
                    { label: "Pacote", value: "PACOTE" }
                ]
            })
        ];
        return searchFields;
    }

    private getProductSearchGridFields() {
        const searchGridFields = [
            // new FormField({
            //     name: "id",
            //     label: "Código",
            //     type: FieldType.String
            // }),
            new FormField({
                name: "description",
                label: "Descrição",
                type: FieldType.String
            }),
            new FormField({
                name: "unit",
                label: "Unidade de medida",
                type: FieldType.Enum,
                placeholder: "Selecione uma unidade de medida",
                options: [
                    { label: "Unidade", value: "UN" },
                    { label: "Dúzia", value: "DZ" },
                    { label: "ml", value: "ML" },
                    { label: "l", value: "L" },
                    { label: "kg", value: "KG" },
                    { label: "g", value: "G" },
                    { label: "Caixa", value: "CAIXA" },
                    { label: "Embalagem", value: "EMBALAGEM" },
                    { label: "Galão", value: "GALAO" },
                    { label: "Garrafa", value: "GARRAFA" },
                    { label: "Lata", value: "LATA" },
                    { label: "Pacote", value: "PACOTE" }
                ]
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
                    summary: "Sucesso",
                    detail: "Registro(s) excluído(s) com sucesso"
                });
                this.goBack();
            })
        );
    }
}
