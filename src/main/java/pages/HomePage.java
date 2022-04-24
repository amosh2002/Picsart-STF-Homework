package pages;

import org.openqa.selenium.By;

import static locators.HomePageLocators.*;

public class HomePage extends BasePage {

    private final By blogButton = By.cssSelector(BLOG_BUTTON.getLocator());
    private final By testimonialsCarousel = By.cssSelector(TESTIMONIALS_CAROUSEL.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    @Override
    public void isLoaded() {
        isElementDisplayed(blogButton);
    }


    public BlogPage clickBlogButton() {
        click(blogButton);
        return new BlogPage();
    }

    public void swipeToTestimonialsCarousel() {
        scrollToElement(testimonialsCarousel);
    }

    public String getPressAndReviewsHeading() {
        return getText(testimonialsCarousel);
    }


}
