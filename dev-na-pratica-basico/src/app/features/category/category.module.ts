import { NgModule } from "@angular/core";
import { MessageService } from 'primeng/api';
import { SharedModule } from 'src/app/shared/shared.module';
import { CategoryRouterModule } from './category.routing';
import { CategoryFormComponent } from './views/form/category-form.component';
import { CategoryListComponent } from './views/list/category-list.component';

@NgModule({
    declarations: [CategoryFormComponent, CategoryListComponent],
    imports: [SharedModule, CategoryRouterModule],
    providers: [
        MessageService,
    ]
})
export class CategoryFeatureModule { }
