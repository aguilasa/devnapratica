import { NgModule } from "@angular/core";
import { PermissionsModule } from "@seniorsistemas/platform-components";
import { ProductService } from './product.service';

@NgModule({
    imports: [
        PermissionsModule.forChild([
            {
                name: "product",
                actions: ["Visualizar", "Incluir", "Editar", "Excluir"],
                uri: `res://senior.com.br/furb/basico/entities/product`,
            },
        ]),
    ],
    providers: [
        ProductService,
    ],
    declarations: [
    ],
    exports: [
    ],
})
export class ProductModule { }
