import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";

import { SharedModule } from "~shared/shared.module";
import { ShoppingListFeatureRouting } from "~features/shopping-list/shopping-list-feature.routing";
import { ShoppingListFormComponent } from "~features/shopping-list/views/form/shopping-list-form.component";
import { ShoppingListListComponent } from "~features/shopping-list/views/list/shopping-list-list.component";

@NgModule({
    imports: [LocaleModule.forChild(), SharedModule, ShoppingListFeatureRouting],
    declarations: [ShoppingListListComponent, ShoppingListFormComponent],
    providers: [],
    exports: []
})
export class ShoppingListFeatureModule {}
