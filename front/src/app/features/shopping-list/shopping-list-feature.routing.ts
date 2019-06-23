import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { MessageService } from "primeng/components/common/messageservice";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";

import { ShoppingListListComponent } from "~features/shopping-list/views/list/shopping-list-list.component";
import { ShoppingListFormComponent } from "~features/shopping-list/views/form/shopping-list-form.component";
import { ShoppingListService } from "~core/entities/shopping-list/shopping-list.service";

@Injectable()
export class ShoppingListFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("shoppingList").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class ShoppingListFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("furb.basico.shopping_list_form_title");
    }
}

@Injectable()
export class ShoppingListFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("furb.basico.shopping_list_list_title");
    }
}

@Injectable()
export class ShoppingListFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class ShoppingListFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
    }
}

@Injectable()
export class ShoppingListFeatureRoutingEntityResolver {
    constructor(private shoppingListService: ShoppingListService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.shoppingList === "new") return;

        return this.shoppingListService.get(route.params.shoppingList);
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
        path: "shopping-list",
        component: EmptyComponent,
        canActivate: [ShoppingListFeatureRoutingGuard],
        resolve: {
            allPermissions: ShoppingListFeatureRoutingPermissionResolver,
            localeConfig: ShoppingListFeatureRoutingLocaleResolver,
            routeTitle: ShoppingListFeatureRoutingListTitleResolver
        },
        children: [
            {
                path: "",
                component: ShoppingListListComponent
            },
            {
                path: ":shoppingList",
                component: EmptyComponent,
                canActivate: [ShoppingListFeatureRoutingGuard],
                resolve: {
                    routeTitle: ShoppingListFeatureRoutingFormTitleResolver,
                    entity: ShoppingListFeatureRoutingEntityResolver
                },
                children: [
                    {
                        path: "",
                        component: ShoppingListFormComponent
                    }
                ]
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
    providers: [
        ShoppingListFeatureRoutingGuard,
        ShoppingListFeatureRoutingPermissionResolver,
        ShoppingListFeatureRoutingLocaleResolver,
        ShoppingListFeatureRoutingFormTitleResolver,
        ShoppingListFeatureRoutingListTitleResolver,
        ShoppingListFeatureRoutingEntityResolver
    ],
    declarations: [EmptyComponent]
})
export class ShoppingListFeatureRouting {}
