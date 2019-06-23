import { ItemListDto } from "~core/entities/item-list/item-list-dto";
import { Category } from "~core/entities/category/category";
import { Unit } from "~core/enums/unit";

export class ItemList {
    public id?: string;
    public description: string;
    public quantity: number;
    public unit: Unit;
    public price: number;
    public category: Category;
    public note?: string;

    public static fromDto(itemListDto: ItemListDto): ItemList {
        const model: any = { ...itemListDto };

        return model as ItemList;
    }

    public static toDto(itemList: ItemList): ItemListDto {
        const dto: any = { ...itemList };

        return dto;
    }
}
