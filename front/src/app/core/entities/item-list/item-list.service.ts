import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { MessageService } from "primeng/components/common/messageservice";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { environment } from "~environments/environment";
import { ItemListDto } from "~core/entities/item-list/item-list-dto";
import { EntityService } from "~core/entities/entity-service";

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@Injectable()
export class ItemListService extends EntityService<ItemListDto> {
    /*{CA:CLASS_ATTRIBUTES:START}*/
    /*{CA:CLASS_ATTRIBUTES:END}*/

    constructor(protected http: HttpClient, protected messageService: MessageService) {
        super(http, messageService, `${environment.project.domain}/${environment.project.service}/entities/itemList`);
        /*{CA:CONSTRUCTOR_END:START}*/
        /*{CA:CONSTRUCTOR_END:END}*/
    }

    /*{CA:CLASS_METHODS:START}*/
    /*{CA:CLASS_METHODS:END}*/
}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
