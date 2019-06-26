import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { SharedModule } from "~shared/shared.module";
import { ProductFeatureRouting } from "~features/product/product-feature.routing";
import { ProductFormComponent } from "~features/product/views/form/product-form.component";
import { ProductListComponent } from "~features/product/views/list/product-list.component";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@NgModule({
    imports: [
        LocaleModule.forChild(),
        SharedModule,
        ProductFeatureRouting,
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    declarations: [
        ProductListComponent,
        ProductFormComponent,

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
export class ProductFeatureModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
