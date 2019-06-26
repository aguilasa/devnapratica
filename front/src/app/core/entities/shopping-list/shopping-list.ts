/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ShoppingListDto } from "~core/entities/shopping-list/shopping-list-dto";
import { ItemList } from "~core/entities/item-list/item-list";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class ShoppingList {
    public id?: string;
    public description: string;
    public items: ItemList[];

    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(shoppingListDto: ShoppingListDto): ShoppingList {
        const model: any = { ...shoppingListDto };

        return model as ShoppingList;
    }

    public static toDto(shoppingList: ShoppingList): ShoppingListDto {
        const dto: any = { ...shoppingList };

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
