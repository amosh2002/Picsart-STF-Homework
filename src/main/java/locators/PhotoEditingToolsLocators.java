package locators;

public enum PhotoEditingToolsLocators {

    LEARN_MORE_BUTTON("[data-test=\"action-button-2-undefined\"]");

    private final String locator;

    PhotoEditingToolsLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
