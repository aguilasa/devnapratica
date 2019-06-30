import { ItemList } from '../item-list/item-list';
import { ShoppingListDto } from './shopping-list-dto';

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
