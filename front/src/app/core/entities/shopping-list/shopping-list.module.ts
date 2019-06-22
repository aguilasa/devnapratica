import { NgModule } from "@angular/core";
import { PermissionsModule } from "@seniorsistemas/platform-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ShoppingListService } from "~core/entities/shopping-list/shopping-list.service";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@NgModule({
    imports: [
        PermissionsModule.forChild([
            {
                name: "shoppingList",
                actions: ["Visualizar", "Incluir", "Editar", "Excluir"],
                uri: `res://senior.com.br/furb/basico/entities/shoppingList`,
            },
        ]),
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    providers: [
        ShoppingListService,
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    declarations: [
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    exports: [
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class ShoppingListModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
