import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { EntityService } from "../entity-service";
import { ShoppingListDto } from "./shopping-list-dto";

@Injectable()
export class ShoppingListService extends EntityService<ShoppingListDto> {
    constructor(protected http: HttpClient) {
        super(http, "shoppingList");
    }

    public returnShoppingList(idList: string) {
        const url = "https://platform-homologx.senior.com.br/t/senior.com.br/bridge/1.0/rest/furb/basico/queries/returnShoppingList";
        return this.http.post<ShoppingListDto[]>(url, { id: idList }, { headers: this.headers }).pipe(this.defaultCatch());
    }
}
