import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { SharedModule } from "~shared/shared.module";
import { CategoryFeatureRouting } from "~features/category/category-feature.routing";
import { CategoryFormComponent } from "~features/category/views/form/category-form.component";
import { CategoryListComponent } from "~features/category/views/list/category-list.component";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@NgModule({
    imports: [
        LocaleModule.forChild(),
        SharedModule,
        CategoryFeatureRouting,
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    declarations: [
        CategoryListComponent,
        CategoryFormComponent,

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
export class CategoryFeatureModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
