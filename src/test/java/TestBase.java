import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.DriverUtils;

import java.io.File;
import java.io.IOException;

public abstract class TestBase {
    @BeforeMethod
    public void startDriver() {
        DriverUtils.getDriver();
    }

    @AfterMethod
    public void quitDriver(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            var camera = (TakesScreenshot) DriverUtils.getDriver();
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("src/main/resources/screenshots" + testResult.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        DriverUtils.quitDriver();
    }
}