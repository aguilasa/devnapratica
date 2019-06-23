import { CategoryDto } from "~core/entities/category/category-dto";

export class Category {
    public id?: string;
    public description: string;

    public static fromDto(categoryDto: CategoryDto): Category {
        const model: any = { ...categoryDto };

        return model as Category;
    }

    public static toDto(category: Category): CategoryDto {
        const dto: any = { ...category };

        return dto;
    }
}
