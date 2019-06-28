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
    LoadingStateModule
} from "@seniorsistemas/angular-components";
import { PanelModule } from "primeng/panel";
import { CheckboxModule } from "primeng/checkbox";
import { ConfirmDialogModule } from "primeng/confirmdialog";
import { DropdownModule } from "primeng/dropdown";
import { TabViewModule } from "primeng/tabview";
import { SharedModule as PrimeSharedModule } from "primeng/shared";
import { TableModule } from 'primeng/table';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { KeyFilterModule } from 'primeng/keyfilter';
import { CalendarModule } from 'primeng/calendar';
import { RadioButtonModule } from 'primeng/radiobutton';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';


import { SideNavComponent } from './common/side-nav/side-nav.component';
import { TopBarComponent } from './common/top-bar/top-bar.component';

@NgModule({
    declarations: [SideNavComponent, TopBarComponent],
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
        CommonModule,
        CardModule,
        ButtonModule,
        TableModule,
        ReactiveFormsModule,
        InputTextModule,
        KeyFilterModule,
        CalendarModule,
        RadioButtonModule,
        MessageModule,
        ToastModule
    ],
    imports: [
        CommonModule
    ]
})
export class SharedModule { }
