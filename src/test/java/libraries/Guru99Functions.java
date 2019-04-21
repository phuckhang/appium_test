package libraries;

import io.appium.java_client.android.AndroidDriver;
import objects.Guru99Page;
import org.testng.Assert;

public class Guru99Functions extends Guru99Page {
    public Guru99Functions(AndroidDriver driver) {
        super(driver);
    }

    public void fillGuruForm(String text) {
        txtText.sendKeys(text);
    }

    public void clickShowButton() {
        btnShow.click();
    }

    public void verifyTextChange(String expectedText) {
        Assert.assertEquals(expectedText, lblView.getText());
    }

}
