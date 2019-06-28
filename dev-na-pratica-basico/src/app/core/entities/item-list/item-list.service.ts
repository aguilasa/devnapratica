import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { EntityService } from '../entity-service';
import { ItemListDto } from './item-list-dto';

@Injectable()
export class ItemListService extends EntityService<ItemListDto> {

    constructor(protected http: HttpClient) {
        super(http, 'itemList');
    }
}

