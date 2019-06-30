import { Unit } from '../../enums/unit';
import { ProductDto } from './product-dto';
import { Category } from '../category/category';

export class Product {
    public id?: string;
    public description: string;
    public unit: Unit;
    public category: Category;

    public static fromDto(productDto: ProductDto): Product {
        const model: any = { ...productDto };

        return model as Product;
    }

    public static toDto(product: Product): ProductDto {
        const dto: any = { ...product };

        return dto;
    }
}
