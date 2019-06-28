import { Routes, RouterModule } from '@angular/router';
import { CategoryFormComponent } from './views/form/category-form.component';
import { CategoryListComponent } from './views/list/category-list.component';
import { CategoryResolver } from './views/form/category.resolver';
import { NgModule } from '@angular/core';


const routes: Routes = [{
    path: 'category', children: [
        {
            path: 'create', component: CategoryFormComponent
        },
        {
            path: 'list', component: CategoryListComponent
        },
        {
            path: 'edit/:id', component: CategoryFormComponent, resolve: [CategoryResolver]
        }
    ]
}];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class CategoryRouterModule { }
