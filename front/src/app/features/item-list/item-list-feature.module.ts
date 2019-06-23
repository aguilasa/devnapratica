import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";

import { SharedModule } from "~shared/shared.module";
import { ItemListFeatureRouting } from "~features/item-list/item-list-feature.routing";
import { ItemListFormComponent } from "~features/item-list/views/form/item-list-form.component";
import { ItemListListComponent } from "~features/item-list/views/list/item-list-list.component";

@NgModule({
    imports: [LocaleModule.forChild(), SharedModule, ItemListFeatureRouting],
    declarations: [ItemListListComponent, ItemListFormComponent],
    providers: [],
    exports: []
})
export class ItemListFeatureModule {}
