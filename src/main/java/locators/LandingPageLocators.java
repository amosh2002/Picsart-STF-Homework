package locators;

public enum LandingPageLocators {
    BUTTONS("[data-testid=\"button-cta\"]"),
    TITLES("[class*=\"banner-content-root\"]"),
    DESCRIPTIONS("[data-test*=\"description\"]");

    private final String locator;

    LandingPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
