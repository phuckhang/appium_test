package configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import datas.Guru99Data;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import supports.GetScreenShot;

import static supports.CommonFunctions.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase extends Guru99Data {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;
    private ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @BeforeTest
    public static void setUp() {
        service = new AppiumServiceBuilder().usingAnyFreePort().build();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium service node is not started");
        }

        File app = new File("./app/android/Guru99App.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP, app);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, getDeviceInfo("platformName"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, getDeviceInfo("platformVersion"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, getDeviceInfo("deviceName"));
        caps.setCapability("appPackage", getDeviceInfo("appPackage"));
        caps.setCapability("appActivity", getDeviceInfo("appActivity"));
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        driver = new AndroidDriver<AndroidElement>(service.getUrl(), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        service.stop();
    }

    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "ReportTest");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User name", "Khang");
        htmlReporter.config().setDocumentTitle("ExtentReport");
        htmlReporter.config().setReportName("Auto Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel("Failed test case is " + result.getName(), ExtentColor.RED));
            logger.log(Status.FAIL, "Test case is failed because: " + result.getThrowable());
            String screenShotPath = GetScreenShot.capture(driver, result.getName());
            logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenShotPath));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.FAIL, "Skipped test case is " + result.getName());
        }
        extent.flush();
    }

    public void logPassed(String description) {
        logger.log(Status.PASS, MarkupHelper.createLabel(description, ExtentColor.GREEN));
    }

}
