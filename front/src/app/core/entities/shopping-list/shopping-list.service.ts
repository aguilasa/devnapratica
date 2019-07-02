import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { EntityService } from "../entity-service";
import { ShoppingListDto } from "./shopping-list-dto";

@Injectable()
export class ShoppingListService extends EntityService<ShoppingListDto> {
    constructor(protected http: HttpClient) {
        super(http, "shoppingList");
    }

    public shoppingListQuery(idList: string) {
        const url = `${this.baseUrl}/queries/shoppingListQuery`;
        return this.http.post<any>(url, { id: idList }, { headers: this.headers }).pipe(this.defaultCatch());
    }

    public persistShoppingList(dto: ShoppingListDto) {
        const url = `${this.baseUrl}/actions/persistShoppingList`;
        return this.http.post<any>(url, { shoppingList: dto }, { headers: this.headers }).pipe(this.defaultCatch());
    }
}
