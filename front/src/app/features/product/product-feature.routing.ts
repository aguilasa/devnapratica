import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { MessageService } from "primeng/components/common/messageservice";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ProductListComponent } from "~features/product/views/list/product-list.component";
import { ProductFormComponent } from "~features/product/views/form/product-form.component";
import { ProductService } from "~core/entities/product/product.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class ProductFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("product").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class ProductFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("furb.basico.product_form_title");
    }
}

@Injectable()
export class ProductFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("furb.basico.product_list_title");
    }
}

@Injectable()
export class ProductFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class ProductFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
    }
}

@Injectable()
export class ProductFeatureRoutingEntityResolver {
    constructor(private productService: ProductService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.product === "new") return;

        return this.productService.get(route.params.product);
    }
}

@Component({
    template: `<router-outlet></router-outlet>`,
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "product",
        component: EmptyComponent,
        canActivate: [
            ProductFeatureRoutingGuard,
            /*{CA:PRODUCT_ROUTE_GUARDS:START}*/
            /*{CA:PRODUCT_ROUTE_GUARDS:END}*/
        ],
        resolve: {
            allPermissions: ProductFeatureRoutingPermissionResolver,
            localeConfig: ProductFeatureRoutingLocaleResolver,
            routeTitle: ProductFeatureRoutingListTitleResolver,
            /*{CA:PRODUCT_ROUTE_RESOLVE:START}*/
            /*{CA:PRODUCT_ROUTE_RESOLVE:END}*/
        },
        children: [
            {
                path: "",
                component: ProductListComponent,
            },
            {
                path: ":product",
                component: EmptyComponent,
                canActivate: [ProductFeatureRoutingGuard],
                resolve: {
                    routeTitle: ProductFeatureRoutingFormTitleResolver,
                    entity: ProductFeatureRoutingEntityResolver,
                    /*{CA:PRODUCT_ROUTE_RESOLVE:START}*/
                    /*{CA:PRODUCT_ROUTE_RESOLVE:END}*/
                },
                children: [
                    {
                        path: "",
                        component: ProductFormComponent,
                    },

                    /*{CA:PRODUCT_ROUTE_CHILDREN:START}*/
                    /*{CA:PRODUCT_ROUTE_CHILDREN:END}*/
                ],
            },
            /*{CA:PRODUCT_ROUTE_CHILDREN:START}*/
            /*{CA:PRODUCT_ROUTE_CHILDREN:END}*/
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
        ProductFeatureRoutingGuard,
        ProductFeatureRoutingPermissionResolver,
        ProductFeatureRoutingLocaleResolver,
        ProductFeatureRoutingFormTitleResolver,
        ProductFeatureRoutingListTitleResolver,
        ProductFeatureRoutingEntityResolver,
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
export class ProductFeatureRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
