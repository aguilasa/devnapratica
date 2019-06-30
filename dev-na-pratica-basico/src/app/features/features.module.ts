import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeaturesRouterModule } from './features.routing';
import { ClienteFeatureModule } from './cliente/cliente.module';
import { ItemModule } from './item/item.module';
import { CategoryFeatureModule } from './category/category.module';
import { RouterModule } from '@angular/router';
import { ProductFeatureModule } from './product/product-feature.module';
import { ItemListFeatureModule } from './item-list/item-list-feature.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    FeaturesRouterModule,
    ClienteFeatureModule,
    ItemModule,
    CategoryFeatureModule,
    ProductFeatureModule,
    ItemListFeatureModule
  ],
  exports: [
    RouterModule
  ]
})
export class FeaturesModule { }
