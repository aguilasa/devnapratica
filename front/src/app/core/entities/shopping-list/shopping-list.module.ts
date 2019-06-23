import { NgModule } from "@angular/core";
import { PermissionsModule } from "@seniorsistemas/platform-components";

import { ShoppingListService } from "~core/entities/shopping-list/shopping-list.service";

@NgModule({
    imports: [
        PermissionsModule.forChild([
            {
                name: "shoppingList",
                actions: ["Visualizar", "Incluir", "Editar", "Excluir"],
                uri: `res://senior.com.br/furb/basico/entities/shoppingList`
            }
        ])
    ],
    providers: [ShoppingListService],
    declarations: [],
    exports: []
})
export class ShoppingListModule {}
