package components;

import org.openqa.selenium.By;

import static locators.SignUpPopupComponentLocators.*;

public class SignUpPopupComponent extends BaseComponent {

    private final By signUpForm = By.cssSelector(SIGN_UP_FORM.getLocator());
    private final By closeButton = By.cssSelector(CLOSE_BUTTON.getLocator());

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(signUpForm);
    }

    public void clickCloseButton() {
        click(closeButton);
    }
}
