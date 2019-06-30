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
import { Unit } from "src/app/core/enums/unit";
import { Category } from "src/app/core/entities/category/category";
import { ProductService } from "src/app/core/entities/product/product.service";
import { CategoryService } from "src/app/core/entities/category/category.service";
import { Product } from "src/app/core/entities/product/product";

@Component({
    templateUrl: "./product-form.component.html",
    styleUrls: [],
    providers: [ConfirmationService]
})
export class ProductFormComponent implements OnInit, OnDestroy {
    public formGroup: FormGroup;
    public loading: boolean;

    public mainPanelCollapsed = false;

    public unit: { label: string; value: Unit }[] = [
        { label: "Unidade", value: Unit.UN },
        { label: "Dúzia", value: Unit.DZ },
        { label: "ml", value: Unit.ML },
        { label: "L", value: Unit.L },
        { label: "kg", value: Unit.KG },
        { label: "g", value: Unit.G },
        { label: "Caixa", value: Unit.CAIXA },
        { label: "Embalagem", value: Unit.EMBALAGEM },
        { label: "Galão", value: Unit.GALAO },
        { label: "Garrafa", value: Unit.GARRAFA },
        { label: "Lata", value: Unit.LATA },
        { label: "Pacote", value: Unit.PACOTE }
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
        private productService: ProductService,
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

        this.route.params.pipe(takeUntil(this.ngUnsubscribe)).subscribe((params: any) => this.onRouteParamsChange(params));
        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));

        this.categorySearchFields = this.getCategorySearchFields();
        this.categorySearchGridFields = this.getCategorySearchGridFields();
    }

    public ngOnDestroy() {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    }

    public isNew() {
        return this.routeParams.product == "new";
    }

    public onRouteParamsChange(params: any) {
        this.routeParams = params;
    }

    public onRouteDataChange(data: any) {
        if (data.entity) {
            const canEdit = true;
            if (!canEdit) this.formGroup.disable();
            this.formGroup.patchValue(Product.fromDto(data.entity));
        } else {
            this.formGroup.patchValue(new Product());
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

    public onCategoryLookupRequest(value: string) {
        const filterQuery = `containing(lower(description), lower('${value}'))`;

        this.categoryService
            .listWithParams({ filterQuery, displayFields: ["description"] })
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
                else if (type == FieldType.Date) return `${name} eq '${moment(value).format("YYYY-MM-DD")}'`;
                else if (type == FieldType.Time) return `${name} eq '${moment(value).format("HH:mm:ss")}'`;
                else if (type == FieldType.DateTime) return `${name} eq '${moment(value).format()}'`;
                else if (type == FieldType.Enum) return `${name} eq ${value}`;
                else if (type == FieldType.String) return `containing(lower(${name}), lower('${value}'))`;
                else return `${name} eq '${value}'`;
            })
            .join(" and ");

        this.categoryService
            .listWithParams({ page, sort, filterQuery, displayFields })
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((list: any) => {
                this.categorySearchGridData = list.contents;
                this.categorySearchTotalRecords = list.totalElements;
            });
    }

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            description: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            unit: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])],
            category: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])]
        });

        return formGroup;
    }

    private getCategorySearchFields() {
        const searchFields = [
            new FormField({
                name: "id",
                label: "Código",
                type: FieldType.String
            }),
            new FormField({
                name: "description",
                label: "Descrição da categoria",
                type: FieldType.String
            })
        ];

        return searchFields;
    }

    private getCategorySearchGridFields() {
        const searchGridFields = [
            new FormField({
                name: "id",
                label: "Código",
                type: FieldType.String
            }),
            new FormField({
                name: "description",
                label: "Descrição da categoria",
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
                    detail: "Registro(s) excluído(s) com sucesso"
                });
                this.goBack();
            })
        );
    }
}
