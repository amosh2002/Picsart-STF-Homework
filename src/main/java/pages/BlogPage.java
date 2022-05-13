package pages;

import org.openqa.selenium.By;

import static locators.BlogPageLocators.*;

public class BlogPage extends BasePage {

    private final By mostPopularCarouselNextButton = By.xpath(MOST_POPULAR_CAROUSEL_NEXT.getLocator());
    private final By changeBackgroundButton = By.cssSelector(CHANGE_BACKGROUND.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL + "/blog";
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(mostPopularCarouselNextButton);
    }

    public void scrollToMostPopularCarousel() {
        scrollToElement(mostPopularCarouselNextButton);
    }

    public void clickMostPopularCarouselNextButton() {
        click(mostPopularCarouselNextButton);
    }

    public RemoveBackgroundBlogPage clickChangeBackgroundButton() {
        click(changeBackgroundButton);
        return new RemoveBackgroundBlogPage();
    }

}
