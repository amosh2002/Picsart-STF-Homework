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

    public abstract boolean isLoaded();

    public void open() {
        driver.get(getUrl());
        isLoaded();
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WaitHelper.getInstance().waitForElementToBeVisible(locator);
            return true;
        } catch (Error ignored) {
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

    public void typeIn(By locator, String text) {
        WebElement element = WaitHelper.getInstance().waitForElementToBeVisible(locator);
        element.sendKeys(text);
    }

    public void clearContent(By locator) {
        WebElement element = WaitHelper.getInstance().waitForElementToBeVisible(locator);
        element.clear();
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
