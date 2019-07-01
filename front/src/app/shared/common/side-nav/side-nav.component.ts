import { Component, OnInit } from "@angular/core";

@Component({
    selector: "app-side-nav",
    templateUrl: "./side-nav.component.html",
    styleUrls: ["./side-nav.component.scss"]
})
export class SideNavComponent implements OnInit {
    items = [
        {
            label: "Categoria",
            routerLink: "/category"
        },
        {
            label: "Produto",
            routerLink: "/product"
        },
        {
            label: "Items Lista",
            routerLink: "/item-list"
        },
        {
            label: "Lista de Compras",
            routerLink: "/shopping-list"
        }
    ];

    constructor() {}

    ngOnInit() {}
}
