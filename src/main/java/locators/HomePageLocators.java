package locators;

public enum HomePageLocators {

    SIGN_UP_BUTTON("[data-test=\"signup-button\"]"),
    BLOG_BUTTON("[data-test='blog-hypertext']"),
    TESTIMONIALS_CAROUSEL("[class='testimonials-carousel-carouselHead-0-2-162']");

    private final String locator;

    HomePageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
