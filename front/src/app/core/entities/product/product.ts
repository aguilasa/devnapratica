/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { ProductDto } from "~core/entities/product/product-dto";
import { Category } from "~core/entities/category/category";
import { Unit } from "~core/enums/unit";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class Product {
    public id?: string;
    public description: string;
    public unit: Unit;
    public category: Category;

    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(productDto: ProductDto): Product {
        const model: any = { ...productDto };

        return model as Product;
    }

    public static toDto(product: Product): ProductDto {
        const dto: any = { ...product };

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
