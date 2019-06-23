import { NgModule } from "@angular/core";

import { SharedModule } from "~shared/shared.module";
import { MainRouting } from "~features/main/main.routing";
import { MainComponent } from "~features/main/main.component";
import { ErrorPageComponent } from "./views/error-page/error-page.component";

@NgModule({
    imports: [SharedModule, MainRouting],
    declarations: [MainComponent, ErrorPageComponent],
    providers: [],
    exports: []
})
export class MainModule {}
