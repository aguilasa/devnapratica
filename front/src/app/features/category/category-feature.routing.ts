import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { MessageService } from "primeng/components/common/messageservice";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { CategoryListComponent } from "~features/category/views/list/category-list.component";
import { CategoryFormComponent } from "~features/category/views/form/category-form.component";
import { CategoryService } from "~core/entities/category/category.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class CategoryFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("category").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class CategoryFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("furb.basico.category_form_title");
    }
}

@Injectable()
export class CategoryFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("furb.basico.category_list_title");
    }
}

@Injectable()
export class CategoryFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class CategoryFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
    }
}

@Injectable()
export class CategoryFeatureRoutingEntityResolver {
    constructor(private categoryService: CategoryService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.category === "new") return;

        return this.categoryService.get(route.params.category);
    }
}

@Component({
    template: `<router-outlet></router-outlet>`,
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "category",
        component: EmptyComponent,
        canActivate: [
            CategoryFeatureRoutingGuard,
            /*{CA:CATEGORY_ROUTE_GUARDS:START}*/
            /*{CA:CATEGORY_ROUTE_GUARDS:END}*/
        ],
        resolve: {
            allPermissions: CategoryFeatureRoutingPermissionResolver,
            localeConfig: CategoryFeatureRoutingLocaleResolver,
            routeTitle: CategoryFeatureRoutingListTitleResolver,
            /*{CA:CATEGORY_ROUTE_RESOLVE:START}*/
            /*{CA:CATEGORY_ROUTE_RESOLVE:END}*/
        },
        children: [
            {
                path: "",
                component: CategoryListComponent,
            },
            {
                path: ":category",
                component: EmptyComponent,
                canActivate: [CategoryFeatureRoutingGuard],
                resolve: {
                    routeTitle: CategoryFeatureRoutingFormTitleResolver,
                    entity: CategoryFeatureRoutingEntityResolver,
                    /*{CA:CATEGORY_ROUTE_RESOLVE:START}*/
                    /*{CA:CATEGORY_ROUTE_RESOLVE:END}*/
                },
                children: [
                    {
                        path: "",
                        component: CategoryFormComponent,
                    },

                    /*{CA:CATEGORY_ROUTE_CHILDREN:START}*/
                    /*{CA:CATEGORY_ROUTE_CHILDREN:END}*/
                ],
            },
            /*{CA:CATEGORY_ROUTE_CHILDREN:START}*/
            /*{CA:CATEGORY_ROUTE_CHILDREN:END}*/
        ],
    },
];

@NgModule({
    imports: [
        RouterModule.forChild(routes),
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    exports: [
        RouterModule,
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    providers: [
        CategoryFeatureRoutingGuard,
        CategoryFeatureRoutingPermissionResolver,
        CategoryFeatureRoutingLocaleResolver,
        CategoryFeatureRoutingFormTitleResolver,
        CategoryFeatureRoutingListTitleResolver,
        CategoryFeatureRoutingEntityResolver,
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    declarations: [
        EmptyComponent,
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class CategoryFeatureRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
