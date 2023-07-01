package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TableObject {
    List<Person> table1 = new ArrayList<>();

    @BeforeClass
    public void setUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");


        List<WebElement> rows = driver.findElements(By.cssSelector("table#table1>tbody>tr"));
        for (WebElement row : rows) {
            String lastName = row.findElement(By.cssSelector("td:nth-child(1)")).getText();
            String firstName = row.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String email = row.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String due = row.findElement(By.cssSelector("td:nth-child(4)")).getText();
            String website = row.findElement(By.cssSelector("td:nth-child(5)")).getText();

            Person person = new Person(lastName, firstName, email, due, website);
            table1.add(person);
        }
    }
    @Test
    public void maxDuePerson() {
       Person maxDuePerson = table1.stream().max(Comparator.comparing(Person::getDue)).orElseThrow(NullPointerException::new);
        Assert.assertEquals(String.format("%s %s", maxDuePerson.getLastname(), maxDuePerson.getFirstname()), "Doe Jason");
    }

    @Test
    public void minDuePerson() {
        Person minDuePerson = table1.stream().min(Comparator.comparing(Person::getDue)).orElseThrow(NullPointerException::new);
        Assert.assertEquals(String.format("%s %s", minDuePerson.getLastname(), minDuePerson.getFirstname()), "Smith John");
    }
}
