package pages;

import components.DownloadAppPopUpComponent;
import org.openqa.selenium.By;

import static locators.AppsLandingPageLocators.*;

public class AppsLandingPage extends BasePage {
    private By getNowButtons = By.cssSelector(GET_NOW_BUTTONS.getLocator());
    private By buttons = By.cssSelector(BUTTONS.getLocator());
    private By descriptions = By.cssSelector(DESCRIPTIONS.getLocator());


    public DownloadAppPopUpComponent clickGetNowButton(int index) {
        click(getNowButtons, index);
        return new DownloadAppPopUpComponent();
    }

    public PricingPage clickStartFreeTrialButton() {
        click(buttons, 0);
        return new PricingPage();
    }

    public PicsartPhotoStudioPage clickReadMoreButton() {
        click(buttons, 1);
        return new PicsartPhotoStudioPage();
    }

    public String getDescriptionText(int index) {
        return getText(descriptions, index);
    }


    @Override
    public String getUrl() {
        return BASE_URL + "/apps";
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(getNowButtons);
    }
}
