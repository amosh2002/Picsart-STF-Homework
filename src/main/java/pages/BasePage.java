package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.WaitHelper;

import java.util.List;

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
            WaitHelper.getInstance(5).waitForElementToBeVisible(locator);
            return true;
        } catch (Error ignored) {
            return false;
        }
    }

    public int getNumberOfElements(By locator) {
        try {
            return WaitHelper.getInstance(5).waitForElementsToBeVisible(locator).size();
        } catch (Error ignored) {
            return 0;
        }
    }

    public void click(By locator) {
        WebElement element = WaitHelper.getInstance(5).waitForElementToBeClickable(locator);
        element.click();
    }

    public void click(By locator, int index) {
        List<WebElement> element = WaitHelper.getInstance(5).waitForElementsToBeVisible(locator);
        element.get(index).click();
    }

    public String getText(By locator) {
        WebElement element = WaitHelper.getInstance(5).waitForElementToBeVisible(locator);
        return element.getText();
    }

    public String getAttribute(By locator, String attributeName) {
        WebElement element = WaitHelper.getInstance(5).waitForElementToBeVisible(locator);
        return element.getAttribute(attributeName);
    }

    public String getText(By locator, int index) {
        List<WebElement> element = WaitHelper.getInstance(5).waitForElementsToBeVisible(locator);
        return element.get(index).getText();
    }

    public void typeIn(By locator, String text) {
        WebElement element = WaitHelper.getInstance(5).waitForElementToBeVisible(locator);
        element.sendKeys(text);
    }

    public void clearContent(By locator) {
        WebElement element = WaitHelper.getInstance(1).waitForElementToBeVisible(locator);
        element.clear();
    }


    public void scrollToElement(By locator) {
        WebElement element = WaitHelper.getInstance(5).waitForElementToBeVisible(locator);
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
