package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.WaitHelper;

import static setup.DriverUtils.driver;


public abstract class BaseComponent {
    protected Actions actions;

    public BaseComponent() {
        actions = new Actions(driver);
    }

    public abstract boolean isLoaded();

    public boolean isElementDisplayed(By locator) {
        try {
            WaitHelper.getInstance().waitForElementToBeVisible(locator);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public void click(By locator) {
        WebElement element = WaitHelper.getInstance().waitForElementToBeClickable(locator);
        element.click();
    }

    public String getText(By locator) {
        WebElement element = WaitHelper.getInstance().waitForElementToBeVisible(locator);
        return element.getText();
    }

    public void scrollToElement(By locator) {
        WebElement element = WaitHelper.getInstance().waitForElementToBeVisible(locator);
        actions.moveToElement(element).perform();
    }

    public String getCurrentUrl() {
        isLoaded();
        return driver.getCurrentUrl();
    }

    public void navigateBack() {
        driver.navigate().back();
    }


}
