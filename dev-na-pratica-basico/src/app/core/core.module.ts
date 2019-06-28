import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteModule } from './entities/cliente/cliente.module';
import { ItemModule } from './entities/item/item.module';
import { CategoryModule } from './entities/category/category.module';
import { ProductModule } from './entities/product/product.module';
import { ItemListModule } from './entities/item-list/item-list.module';
import { ShoppingListModule } from './entities/shopping-list/shopping-list.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ClienteModule,
    ItemModule,
    CategoryModule,
    ProductModule,
    ItemListModule,
    ShoppingListModule,
  ]
})
export class CoreModule { }
