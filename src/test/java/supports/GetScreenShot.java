package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetScreenShot {

    public static String capture(WebDriver driver, String screenShotName) throws IOException {

        String dateFormat = new SimpleDateFormat("ddMMyyyy_hhmmss").format(Calendar.getInstance().getTime());
        String dest = System.getProperty("user.dir") + "/src/test/java/reports/images/" + screenShotName + "_" + dateFormat + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        return dest;
    }
}