import { NgModule } from "@angular/core";
import { PermissionsModule } from "@seniorsistemas/platform-components";
import { CategoryService } from "./category.service";

@NgModule({
    imports: [
        PermissionsModule.forChild([
            {
                name: "category",
                actions: ["Visualizar", "Incluir", "Editar", "Excluir"],
                uri: `res://senior.com.br/furb/basico/entities/category`,
            },
        ]),
    ],
    providers: [
        CategoryService,
    ],
    declarations: [
    ],
    exports: [
    ],
})
export class CategoryModule { }
