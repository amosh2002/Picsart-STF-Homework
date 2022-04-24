package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.WaitHelper;

import static setup.DriverUtils.driver;


public abstract class BasePage {
    protected Actions actions;
    public static final String BASE_URL = "https://picsartstage2.com";

    public BasePage() {
        actions = new Actions(driver);
    }

    public abstract String getUrl();

    public abstract void isLoaded();

    public void open() {
        driver.get(getUrl());
        isLoaded();
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WaitHelper.getInstance().waitForElementToBeClickable(locator);
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
        WebElement element = WaitHelper.getInstance().waitForElementToBeClickable(locator);
        return element.getText();
    }

    public void scrollToElement(By locator) {
        WebElement element = WaitHelper.getInstance().waitForElementToBeClickable(locator);
        actions.moveToElement(element).perform();
    }

    public String getCurrentUlr() {
        isLoaded();
        return driver.getCurrentUrl();
    }


}
