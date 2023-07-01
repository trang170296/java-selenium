package theInternetSelfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicAuthen {
    WebDriver driver = new ChromeDriver();
    public void visit(String url){
        String USERNAME = "admin";
        String PASSWORD = "admin";
        String urlWithBasicAuth = url.replace("//",String.format("//%s:%s@",USERNAME,PASSWORD));
        driver.get(urlWithBasicAuth);

}

    @Test
    public void goToPageSuccessfullyWithBasicAuth() {
        visit("https://the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals(driver.findElement(By.cssSelector("div div.example h3")).getText(),"Basic Auth");

    }
}
