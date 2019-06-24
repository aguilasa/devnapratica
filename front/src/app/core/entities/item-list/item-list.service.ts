import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { MessageService } from "primeng/components/common/messageservice";

import { environment } from "~environments/environment";
import { ItemListDto } from "~core/entities/item-list/item-list-dto";
import { EntityService } from "~core/entities/entity-service";

@Injectable()
export class ItemListService extends EntityService<ItemListDto> {
    constructor(protected http: HttpClient, protected messageService: MessageService) {
        super(
            http,
            messageService,
            `${environment.restUrl}/entities/itemList`
        );
    }
}
