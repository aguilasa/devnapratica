import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { MessageService } from "primeng/components/common/messageservice";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";

import { ItemListListComponent } from "~features/item-list/views/list/item-list-list.component";
import { ItemListFormComponent } from "~features/item-list/views/form/item-list-form.component";
import { ItemListService } from "~core/entities/item-list/item-list.service";

@Injectable()
export class ItemListFeatureRoutingGuard implements CanActivate {
    constructor(private permissionsService: PermissionsService, private router: Router) {}

    public canActivate() {
        return this.permissionsService.get("itemList").pipe(
            map((permissions: any) => {
                if (!permissions.visualizar) this.router.navigate(["forbidden"]);
                return permissions.visualizar;
            })
        );
    }
}

@Injectable()
export class ItemListFeatureRoutingFormTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("furb.basico.item_list_form_title");
    }
}

@Injectable()
export class ItemListFeatureRoutingListTitleResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return this.translate.get("furb.basico.item_list_list_title");
    }
}

@Injectable()
export class ItemListFeatureRoutingPermissionResolver {
    constructor(private permissionsService: PermissionsService) {}

    public resolve() {
        return this.permissionsService.get();
    }
}

@Injectable()
export class ItemListFeatureRoutingLocaleResolver {
    constructor(private localeService: LocaleService) {}

    public resolve() {
        return this.localeService.get();
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
        canActivate: [ItemListFeatureRoutingGuard],
        resolve: {
            allPermissions: ItemListFeatureRoutingPermissionResolver,
            localeConfig: ItemListFeatureRoutingLocaleResolver,
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
                canActivate: [ItemListFeatureRoutingGuard],
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
    providers: [
        ItemListFeatureRoutingGuard,
        ItemListFeatureRoutingPermissionResolver,
        ItemListFeatureRoutingLocaleResolver,
        ItemListFeatureRoutingFormTitleResolver,
        ItemListFeatureRoutingListTitleResolver,
        ItemListFeatureRoutingEntityResolver
    ],
    declarations: [EmptyComponent]
})
export class ItemListFeatureRouting {}
