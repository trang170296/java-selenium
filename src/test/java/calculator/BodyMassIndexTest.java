package calculator;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BodyMassIndexPage;

public class BodyMassIndexTest extends BaseTest {

    BodyMassIndexPage bodyMassIndexPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        Browser.launch(browser);
        bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open();
    }

    @BeforeMethod
    void setUp(){
        bodyMassIndexPage.selectMetricTab();
        bodyMassIndexPage.clearForm();
    }

    @DataProvider(name = "abc")
    Object[][] data() {
        return new Object[][]{
                { "30","female", "165", "55", "BMI = 20.2 kg/m2"},
                {"30", "male", "165", "55", "BMI = 20.2 kg/m2"},
                {"60", "male", "165", "55", "BMI = 20.2 kg/m2"},
        };
    }

    @DataProvider(name = "abc1")
    Object[][] data1() {
        return new Object[][]{
                { "30","female", "165", "55", "BMI = 20.2 kg/m2"},
                {"30", "male", "165", "55", "BMI = 20.2 kg/m2"},
                {"60", "male", "165", "55", "BMI = 20.2 kg/m2"},
        };
    }
    @Test(dataProvider = "abc")
    public void tc01(String age, String gender, String weight, String height, String expectedResult){
        bodyMassIndexPage.fillCalculatorForm(age,gender,weight,height);
        Assert.assertEquals(bodyMassIndexPage.getResult(),expectedResult);
    }

}
