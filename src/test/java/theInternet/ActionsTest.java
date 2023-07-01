package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {
    @Test
    void hoverAvatar1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions mouse = new Actions(driver);
        List<WebElement> avatars = driver.findElements(By.cssSelector(".figure img"));
        for (WebElement avatar : avatars) {
            Thread.sleep(1000);
            mouse
                    .moveToElement(avatar)
                    .perform();
        }
    }




    @Test
    void rightClick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions mouse = new Actions(driver);
        mouse
                .contextClick(driver.findElement(By.id("hot-spot")))
                .perform();
        driver.switchTo().alert().accept();
    }


    @Test
    void keyPress()throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        Actions keyboard = new Actions(driver);
        keyboard.sendKeys("A",Keys.ENTER).perform();
        Thread.sleep(1000);

        keyboard.sendKeys("B").perform();
        Thread.sleep(1000);

        keyboard.sendKeys(Keys.ADD).perform();
        Thread.sleep(1000);

        keyboard.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(1000);
    }
}
