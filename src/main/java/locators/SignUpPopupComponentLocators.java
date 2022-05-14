package locators;

public enum SignUpPopupComponentLocators {
    EMAIL_FIELD("[name=\"email\"]"),
    EMAIL_RED_ALERT("[data-test=\"email_field\"] .error"),
    PASSWORD_FIELD("[name=\"password\"]"),
    PASSWORD_RED_ALERT("[data-test=\"password_field\"] .error"),
    CREATE_FREE_ACCOUNT_BUTTON("[data-test=\"signup\"]"),
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
