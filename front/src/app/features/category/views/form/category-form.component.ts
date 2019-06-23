import { Component, OnInit, OnDestroy, TemplateRef, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { HotkeysService, Hotkey } from "angular2-hotkeys";
import { MessageService } from "primeng/components/common/messageservice";
import { ConfirmationService } from "primeng/api";
import { FormBuilder, FormGroup, FormControl, Validators } from "@angular/forms";
import { TranslateService } from "@ngx-translate/core";
import { Subject } from "rxjs";
import { tap, takeUntil } from "rxjs/operators";

import { Category } from "~core/entities/category/category";

import { CategoryService } from "~core/entities/category/category.service";

@Component({
    templateUrl: "./category-form.component.html",
    styleUrls: [],
    providers: [ConfirmationService]
})
export class CategoryFormComponent implements OnInit, OnDestroy {
    public localeConfig: any = {};
    public permissions: any = {};
    public allPermissions: any = {};

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
        private formBuilder: FormBuilder,
        private translate: TranslateService,
        private hotkeysService: HotkeysService
    ) {}

    public ngOnInit() {
        this.formGroup = this.getFormGroup();

        this.route.params
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((params: any) => this.onRouteParamsChange(params));
        this.route.data
            .pipe(takeUntil(this.ngUnsubscribe))
            .subscribe((data: any) => this.onRouteDataChange(data));

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
        return this.routeParams.category == "new";
    }

    public onRouteParamsChange(params: any) {
        this.routeParams = params;
    }

    public onRouteDataChange(data: any) {
        this.localeConfig = data.localeConfig;
        this.permissions = data.allPermissions.category;
        this.allPermissions = data.allPermissions;
        if (data.entity) {
            const canEdit = this.permissions.editar;
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

    private getFormGroup() {
        const formGroup = this.formBuilder.group({
            id: [{ value: undefined, disabled: true }, Validators.compose([])],
            description: [
                { value: undefined, disabled: false },
                Validators.compose([Validators.required])
            ]
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
                    summary: this.translate.instant("deleted_message_title"),
                    detail: this.translate.instant("deleted_message_content")
                });
                this.goBack();
            })
        );
    }
}
