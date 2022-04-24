package pages;

import org.openqa.selenium.By;

import static locators.RemoveBackgroundBlogPageLocators.*;

public class RemoveBackgroundBlogPage extends BasePage {

    private final By removeBackgroundTitle = By.cssSelector(REMOVE_BACKGROUND_TITLE.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL + "/blog/post/new-background-remove-tool";
    }

    @Override
    public void isLoaded() {
        isElementDisplayed(removeBackgroundTitle);
    }
}
