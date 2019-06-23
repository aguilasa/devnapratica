import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { MessageService } from "primeng/components/common/messageservice";

import { environment } from "~environments/environment";
import { ShoppingListDto } from "~core/entities/shopping-list/shopping-list-dto";
import { EntityService } from "~core/entities/entity-service";

@Injectable()
export class ShoppingListService extends EntityService<ShoppingListDto> {
    constructor(protected http: HttpClient, protected messageService: MessageService) {
        super(
            http,
            messageService,
            `${environment.project.domain}/${environment.project.service}/entities/shoppingList`
        );
    }
}
