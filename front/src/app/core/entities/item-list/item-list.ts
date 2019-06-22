/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ItemListDto } from "~core/entities/item-list/item-list-dto";
import { Category } from "~core/entities/category/category";
import { Unit } from "~core/enums/unit";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class ItemList {
    public id?: string;
    public description: string;
    public quantity: number;
    public unit: Unit;
    public price: number;
    public category: Category;
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
