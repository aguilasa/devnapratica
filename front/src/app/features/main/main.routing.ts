import { NgModule, Injectable } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { of } from "rxjs";
import { TranslateService } from "@ngx-translate/core";

import { environment } from "~environments/environment";
import { MainComponent } from "~features/main/main.component";
import { ErrorPageComponent } from "./views/error-page/error-page.component";

export class TitleResolver {
    public resolve() {
        return of(`${environment.name} (${environment.version})`);
    }
}

@Injectable()
export class NotFoundTranslationsResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return of({
            title: this.translate.instant("error_not_found_title"),
            description: this.translate.instant("error_not_found_description")
        });
    }
}

@Injectable()
export class ForbiddenTranslationsResolver {
    constructor(private translate: TranslateService) {}

    public resolve() {
        return of({
            title: this.translate.instant("error_forbidden_title"),
            description: this.translate.instant("error_forbidden_description")
        });
    }
}

export const routes: Routes = [
    {
        path: "main",
        component: MainComponent,
        resolve: {
            routeTitle: TitleResolver
        }
    },
    {
        path: "not-found",
        component: ErrorPageComponent,
        data: {
            errorCode: 404,
            routeTitle: "404"
        },
        resolve: {
            translations: NotFoundTranslationsResolver
        }
    },
    {
        path: "forbidden",
        component: ErrorPageComponent,
        data: {
            errorCode: 403,
            routeTitle: "403"
        },
        resolve: {
            translations: ForbiddenTranslationsResolver
        }
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
    providers: [TitleResolver, NotFoundTranslationsResolver, ForbiddenTranslationsResolver]
})
export class MainRouting {}
