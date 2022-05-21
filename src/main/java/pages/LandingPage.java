package pages;

import locators.LandingPageLocators;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {
    private By buttons = By.cssSelector(LandingPageLocators.BUTTONS.getLocator());
    private By titles = By.cssSelector(LandingPageLocators.TITLES.getLocator());
    private By descriptions = By.cssSelector(LandingPageLocators.DESCRIPTIONS.getLocator());

    private String toolName;

    public LandingPage(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/" + toolName;
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(titles);
    }

    public EditorPage clickButton(int index) {
        click(buttons, index);
        return new EditorPage();
    }

    public String getTitleText(int index) {
        return getText(titles, index);
    }

    public String getDescriptionText(int index) {
        return getText(descriptions, index);
    }
}
