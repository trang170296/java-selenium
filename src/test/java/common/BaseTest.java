package common;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static common.Browser.*;

public abstract class BaseTest {


    @AfterMethod
    protected void captureScreenShotIfFail(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            captureScreenShot(testResult.getMethod().getMethodName());
        }
    }
    @AfterClass
    protected void closeBrowser() {
        quit();
    }
}