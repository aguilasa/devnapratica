import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, ActivatedRouteSnapshot } from "@angular/router";
import { ShoppingListService } from "src/app/core/entities/shopping-list/shopping-list.service";
import { ShoppingListListComponent } from "./views/list/shopping-list-list.component";
import { ShoppingListFormComponent } from "./views/form/shopping-list-form.component";

@Injectable()
export class ShoppingListFeatureRoutingFormTitleResolver {
    constructor() {}

    public resolve() {
        return "Lista de Compras";
    }
}

@Injectable()
export class ShoppingListFeatureRoutingListTitleResolver {
    constructor() {}

    public resolve() {
        return "Listas de Compras";
    }
}

@Injectable()
export class ShoppingListFeatureRoutingEntityResolver {
    constructor(private shoppingListService: ShoppingListService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.shoppingList === "new") return;

        return this.shoppingListService.shoppingListQuery(route.params.shoppingList);
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
        resolve: {
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
        ShoppingListFeatureRoutingFormTitleResolver,
        ShoppingListFeatureRoutingListTitleResolver,
        ShoppingListFeatureRoutingEntityResolver
    ],
    declarations: [EmptyComponent]
})
export class ShoppingListFeatureRouting {}
