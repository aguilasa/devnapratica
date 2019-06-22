import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { SharedModule } from "~shared/shared.module";
import { ShoppingListFeatureRouting } from "~features/shopping-list/shopping-list-feature.routing";
import { ShoppingListFormComponent } from "~features/shopping-list/views/form/shopping-list-form.component";
import { ShoppingListListComponent } from "~features/shopping-list/views/list/shopping-list-list.component";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@NgModule({
    imports: [
        LocaleModule.forChild(),
        SharedModule,
        ShoppingListFeatureRouting,
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    declarations: [
        ShoppingListListComponent,
        ShoppingListFormComponent,

        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    providers: [
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    exports: [
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class ShoppingListFeatureModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
