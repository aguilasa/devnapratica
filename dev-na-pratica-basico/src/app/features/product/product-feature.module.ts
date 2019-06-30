import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";
import { SharedModule } from "src/app/shared/shared.module";
import { ProductFeatureRouting } from "./product-feature.routing";
import { ProductListComponent } from "./views/list/product-list.component";
import { ProductFormComponent } from "./views/form/product-form.component";
import { MessageService } from 'primeng/api';

@NgModule({
    imports: [LocaleModule.forChild(), SharedModule, ProductFeatureRouting],
    declarations: [ProductListComponent, ProductFormComponent],
    providers: [
        MessageService,
    ],
    exports: []
})
export class ProductFeatureModule {}
