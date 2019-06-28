import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
    {
        path: 'clientes', redirectTo: 'cliente/list'
    },
    {
        path: 'category', redirectTo: 'category/list'
    },
    {
        path: 'items', redirectTo: 'item/list'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class FeaturesRouterModule { }
