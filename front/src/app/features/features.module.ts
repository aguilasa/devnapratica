import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { TranslationsModule } from "@seniorsistemas/platform-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import * as fallback from "../../locale/pt-BR.json";
import { MainModule } from "~features/main/main.module";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export const routes: Routes = [
    {
        path: "",
        redirectTo: "/main",
        pathMatch: "full",
    },
    {
        path: "",
        loadChildren: "~features/category/category-feature.module#CategoryFeatureModule",
    },
    {
        path: "",
        loadChildren: "~features/item-list/item-list-feature.module#ItemListFeatureModule",
    },
    {
        path: "",
        loadChildren: "~features/shopping-list/shopping-list-feature.module#ShoppingListFeatureModule",
    },

    {
        path: "**",
        redirectTo: "/not-found",
    },
    /*{CA:FEATURE_ROUTES:START}*/
    /*{CA:FEATURE_ROUTES:END}*/
];

@NgModule({
    imports: [
        MainModule,
        TranslationsModule.forChild([
            {
                domain: "furb",
                service: "basico",
                fallback,
            },
        ]),
        RouterModule.forChild(routes),
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    providers: [
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    declarations: [
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    exports: [
        RouterModule,
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class FeaturesModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
