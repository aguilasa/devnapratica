import { Product } from '../product/product';
import { ItemListDto } from './item-list-dto';

export class ItemList {
    public id?: string;
    public product: Product;
    public quantity: number;
    public price: number;
    public checked: boolean = false;
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
