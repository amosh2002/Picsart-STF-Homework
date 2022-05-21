package pages;

import components.SignUpPopupComponent;
import org.openqa.selenium.By;

import static locators.HomePageLocators.*;

public class HomePage extends BasePage {

    private final By signUpButton = By.cssSelector(SIGN_UP_BUTTON.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(signUpButton);
    }

    public SignUpPopupComponent clickSignUpButton() {
        click(signUpButton);
        return new SignUpPopupComponent();
    }


}
