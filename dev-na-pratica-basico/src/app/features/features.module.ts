import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FeaturesRouterModule } from "./features.routing";
import { ClienteFeatureModule } from "./cliente/cliente.module";
import { CategoryFeatureModule } from "./category/category.module";
import { RouterModule } from "@angular/router";
import { ProductFeatureModule } from "./product/product-feature.module";
import { ItemListFeatureModule } from "./item-list/item-list-feature.module";
import { ShoppingListFeatureModule } from "./shopping-list/shopping-list-feature.module";

@NgModule({
    declarations: [],
    imports: [
        CommonModule,
        FeaturesRouterModule,
        ClienteFeatureModule,
        CategoryFeatureModule,
        ProductFeatureModule,
        ItemListFeatureModule,
        ShoppingListFeatureModule
    ],
    exports: [RouterModule]
})
export class FeaturesModule {}
