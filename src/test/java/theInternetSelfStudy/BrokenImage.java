package theInternetSelfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenImage {
    @Test
        public void checkBrokenImage() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> listImg = driver.findElements(By.cssSelector("div.example img"));
        List<Integer> listBorkenImg = new ArrayList<>();
        for(WebElement img:listImg){
            URL path = new URL(img.getAttribute("src"));
            HttpURLConnection con = (HttpURLConnection)path.openConnection();
            con.setRequestMethod("GET");
            if (con.getResponseCode()!=200){
                listBorkenImg.add(List.of(listImg).indexOf(img));
            }
        }
        System.out.println(listImg.size());
        System.out.println(listBorkenImg.size());
    }



}
