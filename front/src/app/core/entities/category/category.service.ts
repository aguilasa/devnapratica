import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { MessageService } from "primeng/components/common/messageservice";

import { environment } from "~environments/environment";
import { CategoryDto } from "~core/entities/category/category-dto";
import { EntityService } from "~core/entities/entity-service";

@Injectable()
export class CategoryService extends EntityService<CategoryDto> {
    constructor(protected http: HttpClient, protected messageService: MessageService) {
        super(
            http,
            messageService,
            `${environment.project.domain}/${environment.project.service}/entities/category`
        );
    }
}
