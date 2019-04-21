package objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supports.CommonFunctions;

import java.util.concurrent.TimeUnit;

public class Guru99Page {
    public Guru99Page(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
        CommonFunctions.waitForElementPresent(driver, txtText, 60);
    }

    @FindBy(id = "com.guru99app:id/edtText")
    public AndroidElement txtText;

    @FindBy(id = "com.guru99app:id/btnShow")
    public AndroidElement btnShow;

    @FindBy(id = "com.guru99app:id/txtView")
    public AndroidElement lblView;
}
