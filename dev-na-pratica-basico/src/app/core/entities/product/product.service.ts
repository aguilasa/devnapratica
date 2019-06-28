import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { EntityService } from '../entity-service';
import { ProductDto } from './product-dto';

@Injectable()
export class ProductService extends EntityService<ProductDto> {

    constructor(protected http: HttpClient) {
        super(http, 'product');
    }
}
