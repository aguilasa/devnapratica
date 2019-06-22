import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule, PreloadAllModules } from "@angular/router";
import { GrowlModule } from "primeng/growl";
import { HotkeyModule } from "angular2-hotkeys";
import { MessageService } from "primeng/components/common/messageservice";
import {
    HttpInterceptorModule,
    CyclicJsonInterceptorModule,
    LocaleModule,
    RestUrl,
    BreadcrumbModule,
    LoadingStateModule,
} from "@seniorsistemas/angular-components";
import { of } from "rxjs";
import { TranslationsModule, PermissionsModule } from "@seniorsistemas/platform-components";
import { TranslateModule } from "@ngx-translate/core";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

import { environment } from "~environments/environment";
import { CoreModule } from "~core/core.module";
import { FeaturesModule } from "~features/features.module";
import { AppComponent } from "~app/app.component";
/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

export class CustomRestUrl {
    get() {
        return of(environment.restUrl);
    }
}

@NgModule({
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        RouterModule.forRoot([], { paramsInheritanceStrategy: "always", preloadingStrategy: PreloadAllModules, useHash: true }),
        HttpClientModule,
        HttpInterceptorModule,
        CyclicJsonInterceptorModule,
        LocaleModule.forRoot(),
        PermissionsModule.forRoot([], { ignorePermissions: environment.ignorePermissions }),
        BreadcrumbModule,
        GrowlModule,
        LoadingStateModule,
        HotkeyModule.forRoot(),
        TranslateModule.forRoot(),
        TranslationsModule.forRoot([]),
        FeaturesModule,
        CoreModule,
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    declarations: [
        AppComponent,
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    providers: [
        MessageService,
        { provide: RestUrl, useFactory: () => (!environment.production && environment.restUrl ? new CustomRestUrl() : new RestUrl()) },
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    bootstrap: [AppComponent],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class AppModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
