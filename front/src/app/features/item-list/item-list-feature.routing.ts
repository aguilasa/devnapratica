import { NgModule, Injectable, Component } from "@angular/core";
import { RouterModule, Routes, CanActivate, ActivatedRouteSnapshot, Router } from "@angular/router";
import { map } from "rxjs/operators";
import { MessageService } from "primeng/components/common/messageservice";
import { TranslateService } from "@ngx-translate/core";
import { PermissionsService } from "@seniorsistemas/platform-components";
import { LocaleService } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ItemListListComponent } from "~features/item-list/views/list/item-list-list.component";
import { ItemListFormComponent } from "~features/item-list/views/form/item-list-form.component";
import { ItemListService } from "~core/entities/item-list/item-list.service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

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
    template: `<router-outlet></router-outlet>`,
})
export class EmptyComponent {}

export const routes: Routes = [
    {
        path: "item-list",
        component: EmptyComponent,
        canActivate: [
            ItemListFeatureRoutingGuard,
            /*{CA:ITEM_LIST_ROUTE_GUARDS:START}*/
            /*{CA:ITEM_LIST_ROUTE_GUARDS:END}*/
        ],
        resolve: {
            allPermissions: ItemListFeatureRoutingPermissionResolver,
            localeConfig: ItemListFeatureRoutingLocaleResolver,
            routeTitle: ItemListFeatureRoutingListTitleResolver,
            /*{CA:ITEM_LIST_ROUTE_RESOLVE:START}*/
            /*{CA:ITEM_LIST_ROUTE_RESOLVE:END}*/
        },
        children: [
            {
                path: "",
                component: ItemListListComponent,
            },
            {
                path: ":itemList",
                component: EmptyComponent,
                canActivate: [ItemListFeatureRoutingGuard],
                resolve: {
                    routeTitle: ItemListFeatureRoutingFormTitleResolver,
                    entity: ItemListFeatureRoutingEntityResolver,
                    /*{CA:ITEM_LIST_ROUTE_RESOLVE:START}*/
                    /*{CA:ITEM_LIST_ROUTE_RESOLVE:END}*/
                },
                children: [
                    {
                        path: "",
                        component: ItemListFormComponent,
                    },

                    /*{CA:ITEM_LIST_ROUTE_CHILDREN:START}*/
                    /*{CA:ITEM_LIST_ROUTE_CHILDREN:END}*/
                ],
            },
            /*{CA:ITEM_LIST_ROUTE_CHILDREN:START}*/
            /*{CA:ITEM_LIST_ROUTE_CHILDREN:END}*/
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
        ItemListFeatureRoutingGuard,
        ItemListFeatureRoutingPermissionResolver,
        ItemListFeatureRoutingLocaleResolver,
        ItemListFeatureRoutingFormTitleResolver,
        ItemListFeatureRoutingListTitleResolver,
        ItemListFeatureRoutingEntityResolver,
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
export class ItemListFeatureRouting {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
