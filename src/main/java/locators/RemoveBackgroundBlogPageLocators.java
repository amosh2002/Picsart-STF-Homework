package locators;

public enum RemoveBackgroundBlogPageLocators {

    REMOVE_BACKGROUND_TITLE("[class='post-single-postTitle-0-2-221']");

    private final String locator;

    RemoveBackgroundBlogPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
