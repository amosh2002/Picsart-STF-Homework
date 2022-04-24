import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static setup.DriverUtils.driver;

public abstract class TestBase {

    @BeforeClass
    @Parameters("browser")
    public void startRemoteServer(String browser) {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName(browser);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/"), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void startDriver() {
        Cookie cookie = new Cookie("OptanonAlertBoxClosed", "2022-04-23T12:37:16.432Z");
        driver.get("https://picsartstage2.com/");
        driver.manage().addCookie(cookie);
    }

    @AfterMethod
    public void quitDriver(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("src/main/resources/screenshots" + testResult.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}