package locators;

public enum BlogPageLocators {

    MOST_POPULAR_CAROUSEL_NEXT("//*[@id='__next']/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div[2]/button"),
    CHANGE_BACKGROUND("[href='/blog/post/new-background-remove-tool']");

    private final String locator;

    BlogPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
