package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static errors.ErrorMessages.ELEMENT_NOT_FOUND;
import static setup.DriverUtils.driver;

public class WaitHelper {
    private static final Duration DURATION = Duration.ofSeconds(10);

    private WaitHelper() {
    }

    public static WaitHelper getInstance() {
        return new WaitHelper();
    }

    public WebElement waitForElementToBeClickable(By location) {
        try {
            return new WebDriverWait(driver, DURATION).
                    until(ExpectedConditions.elementToBeClickable(location));
        } catch (WebDriverException ignored) {
            throw new Error(location + " " + ELEMENT_NOT_FOUND.getMessage());
        }
    }

    public WebElement waitForElementToBeVisible(By location) {
        try {
            return new WebDriverWait(driver, DURATION).
                    until(ExpectedConditions.visibilityOfElementLocated(location));
        } catch (WebDriverException ignored) {
            throw new Error(location + " " + ELEMENT_NOT_FOUND.getMessage());
        }
    }
}
