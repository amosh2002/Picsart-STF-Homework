package locators;

public enum PicsartPhotoStudioPageLocators {
    PICTURES("[data-testid=\"picture\"]");

    private final String locator;

    PicsartPhotoStudioPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
