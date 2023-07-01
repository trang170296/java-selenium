package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Table {
    @Test
    public void getNameOfMaxDueSuccesfully(){
        /*
        Open browser
        Navigate to https://the-internet.herokuapp.com/tables
        Focus on table 1
        The person who has largest due is "Doe Jacson"
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> dueElementList =  driver.findElements(By.cssSelector("table#table1>tbody>tr>td:nth-child(4)"));

        List<Float> maxDue = dueElementList
                .stream()
                .map(due->due.getText().replace("$",""))
                .map(due->Float.parseFloat(due))
                .collect(Collectors.toList());

        float maxDuevalue= maxDue
                .stream()
                .max(Comparator.naturalOrder()).orElseThrow(NullPointerException::new);

        int maxDueIndex = maxDue.indexOf(maxDuevalue);
        String firstName = driver.findElement(By.cssSelector(String.format("table#table1>tbody>tr:nth-child(%d)>td:nth-child(1)",maxDueIndex+1))).getText();
        String lastName = driver.findElement(By.cssSelector(String.format("table#table1>tbody>tr:nth-child(%d)>td:nth-child(2)",maxDueIndex+1))).getText();
        Assert.assertEquals("Doe Jason",String.format("%s %s",firstName,lastName));

    }


}
