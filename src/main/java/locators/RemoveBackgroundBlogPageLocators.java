package locators;

public enum RemoveBackgroundBlogPageLocators {

    PICSART_LOGO("[class*='logoLink']"),
    START_EDITING_BUTTON("[href='/editing-tools']"),
    NEXT_POST_BUTTON("[class*='nextContent']"),
    ABOUT_TEXT("[class*='about-section-aboutText']");

    private final String locator;

    RemoveBackgroundBlogPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
