package locators;

public enum DownloadAppPopUpComponentLocators {

    CLOSE_BUTTON("[data-test=\"modal-close\"]");

    private final String locator;

    DownloadAppPopUpComponentLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
