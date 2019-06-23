import { Component } from "@angular/core";

import { environment } from "~environments/environment";

@Component({
    templateUrl: "./main.component.html",
    styleUrls: [],
    providers: []
})
export class MainComponent {
    public dependencies = environment.project.serviceDependencies;
}
