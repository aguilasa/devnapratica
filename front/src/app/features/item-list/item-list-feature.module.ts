import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { SharedModule } from "~shared/shared.module";
import { ItemListFeatureRouting } from "~features/item-list/item-list-feature.routing";
import { ItemListFormComponent } from "~features/item-list/views/form/item-list-form.component";
import { ItemListListComponent } from "~features/item-list/views/list/item-list-list.component";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@NgModule({
    imports: [
        LocaleModule.forChild(),
        SharedModule,
        ItemListFeatureRouting,
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    declarations: [
        ItemListListComponent,
        ItemListFormComponent,

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
export class ItemListFeatureModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
