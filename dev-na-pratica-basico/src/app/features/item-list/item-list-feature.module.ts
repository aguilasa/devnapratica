import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";

import { SharedModule } from "src/app/shared/shared.module";
import { ItemListFeatureRouting } from "./item-list-feature.routing";
import { ItemListListComponent } from "./views/list/item-list-list.component";
import { ItemListFormComponent } from "./views/form/item-list-form.component";
import { MessageService } from "primeng/api";

@NgModule({
    imports: [LocaleModule.forChild(), SharedModule, ItemListFeatureRouting],
    declarations: [ItemListListComponent, ItemListFormComponent],
    providers: [MessageService],
    exports: []
})
export class ItemListFeatureModule {}
