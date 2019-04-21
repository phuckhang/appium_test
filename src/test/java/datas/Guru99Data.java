package datas;

import org.testng.annotations.DataProvider;

public class Guru99Data {

    @DataProvider(name = "guru99DataPass")
    public Object[][] guru99DataPass() {
        return new Object[][]{
                new Object[]{"Guru99 Test", "Guru99 Test"}
        };
    }

    @DataProvider(name = "guru99DataFail")
    public Object[][] guru99DataFail() {
        return new Object[][]{
                new Object[]{"What is this?", "Guru99 Test"}
        };
    }
}
