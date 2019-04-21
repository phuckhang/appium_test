package supports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {
    public static String getDeviceInfo(String atbDevice) {
        try {
            File file = new File("./src/test/java/configurations/Android.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            return properties.getProperty(atbDevice);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "File not found";
        } catch (IOException e) {
            e.printStackTrace();
            return "Fail to get device info";
        }
    }

    public static void waitForElementPresent(AndroidDriver driver, AndroidElement element, int timeout) {
        Wait wait = new FluentWait(driver).withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void swipe() {

    }

    public static void scroll() {

    }

    public static void spinner() {

    }

    public static void pressHome() {

    }

    public static void pressMenu() {

    }

    public static void pressBack() {

    }

}
