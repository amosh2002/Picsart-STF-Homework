package locators;

public enum AppsLandingPageLocators {
    GET_NOW_BUTTONS("[data-testid*=\"button-not-cta\"]"),
    BUTTONS("[data-testid=\"button-cta\"]"),
    DESCRIPTIONS("[class*=\"banner-content-root\"]");

    private final String locator;

    AppsLandingPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
