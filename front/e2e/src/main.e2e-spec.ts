import { MainPage } from "~e2e/src/main.po";

describe("Project basico-frontend", () => {
    let mainPage: MainPage;

    beforeEach(() => {
        mainPage = new MainPage();
    });

    it("should display project name", () => {
        mainPage.navigateTo();
        expect(mainPage.getTitleText()).toEqual("basico-frontend".toUpperCase());
    });
});
