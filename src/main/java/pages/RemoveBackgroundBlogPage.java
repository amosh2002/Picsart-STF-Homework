package pages;

import org.openqa.selenium.By;

import static locators.RemoveBackgroundBlogPageLocators.*;

public class RemoveBackgroundBlogPage extends BasePage {

    private final By aboutText = By.cssSelector(ABOUT_TEXT.getLocator());
    private final By startEditingButton = By.cssSelector(START_EDITING_BUTTON.getLocator());
    private final By picsartLogo = By.cssSelector(PICSART_LOGO.getLocator());
    private final By nextPostButton = By.cssSelector(NEXT_POST_BUTTON.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL + "/blog/post/new-background-remove-tool";
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(startEditingButton);
    }

    public String getRemoveBackgroundTitle() {
        return getText(aboutText);
    }

    public HomePage clickPicsartLogo() {
        click(picsartLogo);
        return new HomePage();
    }

    public void scrollToNextPostButton() {
        scrollToElement(nextPostButton);
    }

    public boolean isNextPostButtonPresent() {
        return isElementDisplayed(nextPostButton);
    }
}
