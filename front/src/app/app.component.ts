import { Component, OnInit, TemplateRef, ViewChild } from "@angular/core";
import {
    Router,
    RouterEvent,
    NavigationStart,
    NavigationEnd,
    NavigationCancel,
    NavigationError
} from "@angular/router";
import { MessageService } from "primeng/components/common/messageservice";
import { Message } from "primeng/components/common/api";

@Component({
    selector: "body",
    templateUrl: "./app.component.html",
    styleUrls: [],
    providers: []
})
export class AppComponent implements OnInit {
    public pageLoading: boolean;

    @ViewChild("customTemplate")
    public customTemplate: TemplateRef<any>;

    constructor(private router: Router) {}

    public ngOnInit() {
        this.router.events.subscribe((event: RouterEvent) => {
            if (event instanceof NavigationStart) {
                this.pageLoading = true;
            } else if (
                event instanceof NavigationEnd ||
                event instanceof NavigationCancel ||
                event instanceof NavigationError
            ) {
                this.pageLoading = false;
            }
        });
    }
}
