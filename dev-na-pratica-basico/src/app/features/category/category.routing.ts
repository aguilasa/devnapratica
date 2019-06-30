import { Routes, RouterModule, ActivatedRouteSnapshot } from "@angular/router";
import { CategoryFormComponent } from "./views/form/category-form.component";
import { CategoryListComponent } from "./views/list/category-list.component";
import { NgModule, Component, Injectable } from "@angular/core";
import { CategoryService } from "src/app/core/entities/category/category.service";

@Injectable()
export class CategoryFeatureRoutingEntityResolver {
    constructor(private categoryService: CategoryService) {}

    public resolve(route: ActivatedRouteSnapshot) {
        if (route.params.category === "new") return;

        return this.categoryService.get(route.params.category);
    }
}

@Component({
    template: `
        <router-outlet></router-outlet>
    `
})
export class EmptyComponent {}

const routes: Routes = [
    {
        path: "category",
        component: EmptyComponent,
        children: [
            {
                path: "",
                component: CategoryListComponent
            },
            {
                path: ":category",
                component: EmptyComponent,
                resolve: {
                    entity: CategoryFeatureRoutingEntityResolver
                },
                children: [
                    {
                        path: "",
                        component: CategoryFormComponent
                    }
                ]
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
    providers: [CategoryFeatureRoutingEntityResolver],
    declarations: [EmptyComponent]
})
export class CategoryRouterModule {}
