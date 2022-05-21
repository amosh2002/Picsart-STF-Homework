package components;

import locators.DownloadAppPopUpComponentLocators;
import org.openqa.selenium.By;

public class DownloadAppPopUpComponent extends BaseComponent {

    private By closeButton = By.cssSelector(DownloadAppPopUpComponentLocators.CLOSE_BUTTON.getLocator());

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(closeButton);
    }

    public void clickCloseButton() {
        click(closeButton);
    }
}
