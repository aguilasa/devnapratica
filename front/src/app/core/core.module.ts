import { NgModule } from "@angular/core";

import { CategoryModule } from "~core/entities/category/category.module";
import { ItemListModule } from "~core/entities/item-list/item-list.module";
import { ShoppingListModule } from "~core/entities/shopping-list/shopping-list.module";

@NgModule({
    imports: [CategoryModule, ItemListModule, ShoppingListModule],
    providers: [],
    declarations: [],
    exports: []
})
export class CoreModule {}
