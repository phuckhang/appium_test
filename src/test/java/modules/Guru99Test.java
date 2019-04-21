package modules;

import configurations.TestBase;
import libraries.Guru99Functions;
import org.testng.annotations.Test;

public class Guru99Test extends TestBase {

    @Test(dataProvider = "guru99DataPass")
    public void test_guru(String fillText, String expectedText) {
        logger = extent.createTest("test_guru_passed");
        Guru99Functions guPage = new Guru99Functions(driver);
        guPage.fillGuruForm(fillText);
        logPassed("Fill text");
        guPage.clickShowButton();
        logPassed("Click on show button");
        guPage.verifyTextChange(expectedText);
        logPassed("Verify expectation text");
    }

    @Test(dataProvider = "guru99DataFail")
    public void test_guru_failed(String fillText, String expectedText) {
        logger = extent.createTest("test_guru_failed");
        Guru99Functions guPage = new Guru99Functions(driver);
        guPage.fillGuruForm(fillText);
        logPassed("Fill text");
        guPage.clickShowButton();
        logPassed("Click on show button");
        guPage.verifyTextChange(expectedText);
        logPassed("Verify expectation text");
    }
}
