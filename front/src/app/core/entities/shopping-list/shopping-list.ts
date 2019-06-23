import { ShoppingListDto } from "~core/entities/shopping-list/shopping-list-dto";
import { ItemList } from "~core/entities/item-list/item-list";

export class ShoppingList {
    public id?: string;
    public description: string;
    public items: ItemList[];

    public static fromDto(shoppingListDto: ShoppingListDto): ShoppingList {
        const model: any = { ...shoppingListDto };

        return model as ShoppingList;
    }

    public static toDto(shoppingList: ShoppingList): ShoppingListDto {
        const dto: any = { ...shoppingList };

        return dto;
    }
}
