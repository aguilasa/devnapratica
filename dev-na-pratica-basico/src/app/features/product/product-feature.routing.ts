import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { MessageService } from "primeng/components/common/messageservice";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
import { ProductService } from "src/app/core/entities/product/product.service";
import { ProductListComponent } from "./views/list/product-list.component";
import { ProductFormComponent } from "./views/form/product-form.component";

@Injectable()
export class ProductFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return "Produto";
    }
}

@Injectable()
export class ProductFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return "Produtos";
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
    template: `
        <router-outlet></router-outlet>
    `
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "product",
        component: EmptyComponent,
        resolve: {
            routeTitle: ProductFeatureRoutingListTitleResolver
        },
        children: [
            {
                path: "",
                component: ProductListComponent
            },
            {
                path: ":product",
                component: EmptyComponent,
                resolve: {
                    routeTitle: ProductFeatureRoutingFormTitleResolver,
                    entity: ProductFeatureRoutingEntityResolver
                },
                children: [
                    {
                        path: "",
                        component: ProductFormComponent
                    }
                ]
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
    providers: [ProductFeatureRoutingFormTitleResolver, ProductFeatureRoutingListTitleResolver, ProductFeatureRoutingEntityResolver],
    declarations: [EmptyComponent]
})
export class ProductFeatureRouting {}
