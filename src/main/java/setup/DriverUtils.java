package setup;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverUtils {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            Cookie cookie = new Cookie("OptanonAlertBoxClosed", "2022-04-23T12:37:16.432Z");
            driver.get("https://picsartstage2.com/");
            driver.manage().addCookie(cookie);
        }
        return driver;
    }

    public static void quitDriver() {
        getDriver().quit();
        driver = null;
    }
}
