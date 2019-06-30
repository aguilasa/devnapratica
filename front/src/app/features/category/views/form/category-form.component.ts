import { Component, OnInit, OnDestroy, TemplateRef, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { MessageService } from "primeng/components/common/messageservice";
import { ConfirmationService } from "primeng/api";
import { FormBuilder, FormGroup, FormControl, Validators } from "@angular/forms";
import { Subject } from "rxjs";
import { tap, takeUntil } from "rxjs/operators";
import { CategoryService } from "src/app/core/entities/category/category.service";
import { Category } from "src/app/core/entities/category/category";

@Component({
    templateUrl: "./category-form.component.html",
    styleUrls: [],
    providers: [ConfirmationService]
})
export class CategoryFormComponent implements OnInit, OnDestroy {
    public formGroup: FormGroup;
    public loading: boolean;

    public mainPanelCollapsed = false;

    @ViewChild("customTemplate")
    public customTemplate: TemplateRef<any>;

    @ViewChild("customFormFields")
    public customFormFields: TemplateRef<any>;

    private routeParams: any;
    private ngUnsubscribe = new Subject();

    constructor(
        private categoryService: CategoryService,
        private router: Router,
        private route: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private formBuilder: FormBuilder
    ) {}

    public ngOnInit() {
        this.formGroup = this.getFormGroup();

        this.route.params.pipe(takeUntil(this.ngUnsubscribe)).subscribe((params: any) => this.onRouteParamsChange(params));
        this.route.data.pipe(takeUntil(this.ngUnsubscribe)).subscribe((data: any) => this.onRouteDataChange(data));
    }

    public ngOnDestroy() {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    }

    public isNew() {
        return this.routeParams.category == "new";
    }

    public onRouteParamsChange(params: any) {
        this.routeParams = params;
    }

    public onRouteDataChange(data: any) {
        if (data.entity) {
            const canEdit = true;
            if (!canEdit) this.formGroup.disable();
            this.formGroup.patchValue(Category.fromDto(data.entity));
        } else {
            this.formGroup.patchValue(new Category());
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

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            description: [{ value: undefined, disabled: false }, Validators.compose([Validators.required])]
        });
        return formGroup;
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
        const categoryDto = Category.toDto(value);

        let observable;

        if (this.isNew()) {
            observable = this.categoryService.insert(categoryDto);
        } else {
            const id = this.routeParams.category;
            observable = this.categoryService.update(id, categoryDto);
        }

        return observable;
    }

    private getDeleteObservable() {
        return this.categoryService.delete(this.routeParams.category).pipe(
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
