import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";
import { SharedModule } from "src/app/shared/shared.module";
import { ShoppingListFeatureRouting } from "./shopping-list-feature.routing";
import { ShoppingListListComponent } from "./views/list/shopping-list-list.component";
import { ShoppingListFormComponent } from "./views/form/shopping-list-form.component";
import { MessageService } from "primeng/api";

@NgModule({
    imports: [LocaleModule.forChild(), SharedModule, ShoppingListFeatureRouting],
    declarations: [ShoppingListListComponent, ShoppingListFormComponent],
    providers: [MessageService],
    exports: []
})
export class ShoppingListFeatureModule {}
