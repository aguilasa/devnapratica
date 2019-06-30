import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { MessageService } from "primeng/components/common/messageservice";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
import { ItemListService } from "src/app/core/entities/item-list/item-list.service";
import { ItemListListComponent } from "./views/list/item-list-list.component";
import { ItemListFormComponent } from "./views/form/item-list-form.component";

@Injectable()
export class ItemListFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return "Item";
    }
}

@Injectable()
export class ItemListFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return "Items";
    }
}

@Injectable()
export class ItemListFeatureRoutingEntityResolver {
    constructor(private itemListService: ItemListService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.itemList === "new") return;

        return this.itemListService.get(route.params.itemList);
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
        path: "item-list",
        component: EmptyComponent,
        resolve: {
            routeTitle: ItemListFeatureRoutingListTitleResolver
        },
        children: [
            {
                path: "",
                component: ItemListListComponent
            },
            {
                path: ":itemList",
                component: EmptyComponent,
                resolve: {
                    routeTitle: ItemListFeatureRoutingFormTitleResolver,
                    entity: ItemListFeatureRoutingEntityResolver
                },
                children: [
                    {
                        path: "",
                        component: ItemListFormComponent
                    }
                ]
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
    providers: [ItemListFeatureRoutingFormTitleResolver, ItemListFeatureRoutingListTitleResolver, ItemListFeatureRoutingEntityResolver],
    declarations: [EmptyComponent]
})
export class ItemListFeatureRouting {}
