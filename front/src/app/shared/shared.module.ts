import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { HotkeyModule } from "angular2-hotkeys";
import { CurrencyMaskModule } from "ng2-currency-mask";
import { TranslateModule } from "@ngx-translate/core";
import {
    CustomFieldsModule,
    ControlErrorsModule,
    EmptyStateModule,
    DynamicFormModule,
    TokenListModule,
    LoadingStateModule,
} from "@seniorsistemas/angular-components";
import { PanelModule } from "primeng/panel";
import { InputTextModule } from "primeng/inputtext";
import { ButtonModule } from "primeng/button";
import { CheckboxModule } from "primeng/checkbox";
import { TableModule } from "primeng/table";
import { ConfirmDialogModule } from "primeng/confirmdialog";
import { CalendarModule } from "primeng/calendar";
import { DropdownModule } from "primeng/dropdown";
import { TabViewModule } from "primeng/tabview";
import { SharedModule as PrimeSharedModule } from "primeng/shared";
import { FiltersStorageService } from "./storage/filters-storage.service";
/*{CA:PACKAGE_IMPORTS:START}*/
/*{CA:PACKAGE_IMPORTS:END}*/

/*{CA:PROJECT_IMPORTS:START}*/
/*{CA:PROJECT_IMPORTS:END}*/

@NgModule({
    imports: [
        /*{CA:MODULE_IMPORTS:START}*/
        /*{CA:MODULE_IMPORTS:END}*/
    ],
    exports: [
        FormsModule,
        ReactiveFormsModule,
        CommonModule,
        CurrencyMaskModule,
        TranslateModule,
        CustomFieldsModule,
        ControlErrorsModule,
        EmptyStateModule,
        DynamicFormModule,
        TokenListModule,
        PanelModule,
        InputTextModule,
        ButtonModule,
        CheckboxModule,
        TableModule,
        ConfirmDialogModule,
        CalendarModule,
        DropdownModule,
        TabViewModule,
        PrimeSharedModule,
        HotkeyModule,
        LoadingStateModule,
        /*{CA:MODULE_EXPORTS:START}*/
        /*{CA:MODULE_EXPORTS:END}*/
    ],
    providers: [
        FiltersStorageService,
        /*{CA:MODULE_PROVIDERS:START}*/
        /*{CA:MODULE_PROVIDERS:END}*/
    ],
    declarations: [
        /*{CA:MODULE_DECLARATIONS:START}*/
        /*{CA:MODULE_DECLARATIONS:END}*/
    ],
    /*{CA:MODULE_CONFIG:START}*/
    /*{CA:MODULE_CONFIG:END}*/
})
export class SharedModule {}

/*{CA:FILE_CONTENTS:START}*/
/*{CA:FILE_CONTENTS:END}*/
