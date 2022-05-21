package pages;

import locators.EditorPageLocators;
import org.openqa.selenium.By;

public class EditorPage extends BasePage {
    private By searchField = By.cssSelector(EditorPageLocators.SEARCH_FIELD.getLocator());
    private By dropDown = By.cssSelector(EditorPageLocators.DROP_DOWN.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL + "/editor";
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(searchField);
    }

    public String getSearchFieldText() {
        return getAttribute(searchField, "value");
    }

    public String getDropDownText() {
        return getText(dropDown);
    }
}
