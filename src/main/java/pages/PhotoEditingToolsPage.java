package pages;

import org.openqa.selenium.By;

import static locators.PhotoEditingToolsLocators.*;

public class PhotoEditingToolsPage extends BasePage {

    private final By learnMoreButton = By.cssSelector(LEARN_MORE_BUTTON.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL + "/photo-editing-tools";
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(learnMoreButton);
    }
}
