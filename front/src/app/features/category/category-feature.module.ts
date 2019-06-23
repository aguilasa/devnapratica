import { NgModule } from "@angular/core";
import { LocaleModule } from "@seniorsistemas/angular-components";

import { SharedModule } from "~shared/shared.module";
import { CategoryFeatureRouting } from "~features/category/category-feature.routing";
import { CategoryFormComponent } from "~features/category/views/form/category-form.component";
import { CategoryListComponent } from "~features/category/views/list/category-list.component";

@NgModule({
    imports: [LocaleModule.forChild(), SharedModule, CategoryFeatureRouting],
    declarations: [CategoryListComponent, CategoryFormComponent],
    providers: [],
    exports: []
})
export class CategoryFeatureModule {}
