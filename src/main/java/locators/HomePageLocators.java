package locators;

public enum HomePageLocators {

    SIGN_UP_BUTTON("[data-test=\"signup-button\"]");

    private final String locator;

    HomePageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
