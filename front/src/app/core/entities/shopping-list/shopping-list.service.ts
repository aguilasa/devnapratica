import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { EntityService } from '../entity-service';
import { ShoppingListDto } from './shopping-list-dto';

@Injectable()
export class ShoppingListService extends EntityService<ShoppingListDto> {

    constructor(protected http: HttpClient) {
        super(http, 'shoppingList');
    }
}
