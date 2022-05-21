package locators;

public enum EditorPageLocators {
    SEARCH_FIELD("[placeholder=\"Search\"]"),
    DROP_DOWN("[class*=\"drop-down-root\"]");

    private final String locator;

    EditorPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
