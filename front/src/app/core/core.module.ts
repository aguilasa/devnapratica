import { NgModule } from "@angular/core";
import { CategoryModule } from "~core/entities/category/category.module";
import { ProductModule } from "~core/entities/product/product.module";
import { ItemListModule } from "~core/entities/item-list/item-list.module";
import { ShoppingListModule } from "~core/entities/shopping-list/shopping-list.module";

@NgModule({
    imports: [
        CategoryModule,
        ProductModule,
        ItemListModule,
        ShoppingListModule,
    ],
    providers: [
    ],
    declarations: [
    ],
    exports: [
    ],
})
export class CoreModule {}

