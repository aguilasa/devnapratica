/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { CategoryDto } from "~core/entities/category/category-dto";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class Category {
    public id?: string;
    public description: string;

    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    public static fromDto(categoryDto: CategoryDto): Category {
        const model: any = { ...categoryDto };

        return model as Category;
    }

    public static toDto(category: Category): CategoryDto {
        const dto: any = { ...category };

        return dto;
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
