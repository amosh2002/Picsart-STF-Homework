package locators;

public enum SignUpPopupComponentLocators {
    SIGN_UP_FORM("[data-test=\"sign_up_form\"]"),
    CLOSE_BUTTON("[data-test=\"modal-close\"]");

    private final String locator;

    SignUpPopupComponentLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
