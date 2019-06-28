import { NgModule } from "@angular/core";
import { PermissionsModule } from "@seniorsistemas/platform-components";
import { ItemListService } from './item-list.service';

@NgModule({
    imports: [
        PermissionsModule.forChild([
            {
                name: "itemList",
                actions: ["Visualizar", "Incluir", "Editar", "Excluir"],
                uri: `res://senior.com.br/furb/basico/entities/itemList`,
            },
        ]),
    ],
    providers: [
        ItemListService,
    ],
    declarations: [
    ],
    exports: [
    ],
})
export class ItemListModule { }
