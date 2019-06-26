/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ItemListDto } from "~core/entities/item-list/item-list-dto";
import { Product } from "~core/entities/product/product";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class ItemList {
    public id?: string;
    public product: Product;
    public quantity: number;
    public price: number;
    public checked: boolean = false;
    public note?: string;

    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(itemListDto: ItemListDto): ItemList {
        const model: any = { ...itemListDto };

        return model as ItemList;
    }

    public static toDto(itemList: ItemList): ItemListDto {
        const dto: any = { ...itemList };

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
