package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {
    /*
    1. Select option
    2. Open browser
    3. Navigate to https://the-internet.herokuapp.com/dropdown
    4. Select "option 1"
    5. Validate "option 1" is selected
     */
    @Test
    void selectOption1Successfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //driver.findElement(By.id("dropdown")).click();
        //driver.findElement(By.cssSelector("option[value='1']")).click();
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        //select.selectByIndex(1); from 0
        //select.deselectByValue("1");
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());

    }
}
