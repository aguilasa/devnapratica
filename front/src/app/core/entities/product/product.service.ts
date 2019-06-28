import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "primeng/components/common/messageservice";

import {environment} from "~environments/environment";
import {ProductDto} from "~core/entities/product/product-dto";
import {EntityService} from "~core/entities/entity-service";

@Injectable()
export class ProductService extends EntityService<ProductDto> {

    constructor(protected http: HttpClient, protected messageService: MessageService) {
        super(http, messageService, `${environment.project.urlBase}/entities/product`);
    }
}
