import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { TranslationsModule } from "@seniorsistemas/platform-components";

import * as fallback from "../../locale/pt-BR.json";
import { MainModule } from "~features/main/main.module";

export const routes: Routes = [
    {
        path: "",
        redirectTo: "/main",
        pathMatch: "full"
    },
    {
        path: "",
        loadChildren: "~features/category/category-feature.module#CategoryFeatureModule"
    },
    {
        path: "",
        loadChildren: "~features/product/product-feature.module#ProductFeatureModule"
    },
    {
        path: "",
        loadChildren: "~features/item-list/item-list-feature.module#ItemListFeatureModule"
    },
    {
        path: "",
        loadChildren:
            "~features/shopping-list/shopping-list-feature.module#ShoppingListFeatureModule"
    },

    {
        path: "**",
        redirectTo: "/not-found"
    }
];

@NgModule({
    imports: [
        MainModule,
        TranslationsModule.forChild([
            {
                domain: "furb",
                service: "basico",
                fallback
            }
        ]),
        RouterModule.forChild(routes)
    ],
    providers: [],
    declarations: [],
    exports: [RouterModule]
})
export class FeaturesModule {}
