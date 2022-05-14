package pages;

import components.SignUpPopupComponent;
import org.openqa.selenium.By;

import static locators.HomePageLocators.*;

public class HomePage extends BasePage {

    private final By signUpButton = By.cssSelector(SIGN_UP_BUTTON.getLocator());
    private final By blogButton = By.cssSelector(BLOG_BUTTON.getLocator());
    private final By testimonialsCarousel = By.cssSelector(TESTIMONIALS_CAROUSEL.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(blogButton);
    }


    public BlogPage clickBlogButton() {
        click(blogButton);
        return new BlogPage();
    }

    public SignUpPopupComponent clickSignUpButton() {
        click(signUpButton);
        return new SignUpPopupComponent();
    }

    public void swipeToTestimonialsCarousel() {
        scrollToElement(testimonialsCarousel);
    }

    public String getPressAndReviewsHeading() {
        return getText(testimonialsCarousel);
    }


}
