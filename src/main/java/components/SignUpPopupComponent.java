package components;

import org.openqa.selenium.By;

import static locators.SignUpPopupComponentLocators.*;

public class SignUpPopupComponent extends BaseComponent {

    private final By signUpForm = By.cssSelector(SIGN_UP_FORM.getLocator());
    private final By closeButton = By.cssSelector(CLOSE_BUTTON.getLocator());
    private final By emailField = By.cssSelector(EMAIL_FIELD.getLocator());
    private final By emailRedAlert = By.cssSelector(EMAIL_RED_ALERT.getLocator());
    private final By passwordField = By.cssSelector(PASSWORD_FIELD.getLocator());
    private final By passwordRedAlert = By.cssSelector(PASSWORD_RED_ALERT.getLocator());
    private final By createAccountButton = By.cssSelector(CREATE_FREE_ACCOUNT_BUTTON.getLocator());

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(signUpForm);
    }

    public void clickCloseButton() {
        click(closeButton);
    }

    public void clickEmailField() {
        click(emailField);
    }

    public void typeInEmailField(String text) {
        typeIn(emailField, text);
    }

    public boolean isEmailRedAlertDisplayed() {
        return isElementDisplayed(emailRedAlert, 1);
    }

    public void clearEmailField() {
        clearContent(emailField);
    }

    public void clickPasswordField() {
        click(passwordField);
    }

    public void typeInPasswordField(String text) {
        typeIn(passwordField, text);
    }

    public boolean isPasswordRedAlertDisplayed() {
        return isElementDisplayed(passwordRedAlert, 1);
    }

    public void clearPasswordField() {
        clearContent(passwordField);
    }

    public void clickCreateAccountButton() {
        click(createAccountButton);
    }
}
