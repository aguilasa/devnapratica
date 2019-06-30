import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { EntityService } from '../entity-service';
import { CategoryDto } from './category-dto';


@Injectable()
export class CategoryService extends EntityService<CategoryDto> {

    constructor(protected http: HttpClient) {
        super(http, 'category');
    }
}
