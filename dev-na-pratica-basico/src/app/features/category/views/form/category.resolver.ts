import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from 'src/app/core/entities/category/category';
import { CategoryService } from 'src/app/core/entities/category/category.service';


@Injectable()
export class CategoryResolver implements Resolve<Category> {

    constructor(private service: CategoryService) { }

    resolve(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): Observable<any> | Promise<any> | any {
        return this.service.get(route.paramMap.get('id'));
    }
}
