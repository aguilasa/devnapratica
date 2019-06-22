import { NgModule } from "@angular/core";
import { PermissionsModule } from "@seniorsistemas/platform-components";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { CategoryService } from "~core/entities/category/category.service";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@NgModule({
    imports: [
        PermissionsModule.forChild([
            {
                name: "category",
                actions: ["Visualizar", "Incluir", "Editar", "Excluir"],
                uri: `res://senior.com.br/furb/basico/entities/category`,
            },
        ]),
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    providers: [
        CategoryService,
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    declarations: [
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    exports: [
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class CategoryModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
