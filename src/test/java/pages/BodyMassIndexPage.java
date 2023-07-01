package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

import static common.Browser.*;

public class BodyMassIndexPage {
    By metricTab = By.cssSelector("li#menuon a");
    By clearBtn = By.className("clearbtn");
    By ageTextbox =By.cssSelector("input#cage");
    By femaleRadioButton = By.cssSelector("label[for='csex2'] span");
    By maleRadioButton = By.cssSelector("label[for='csex1'] span");
    By heightTextbox = By.cssSelector("input#cheightmeter");
    By weightTextbox = By.cssSelector("input#ckg");
    By CalculateLabel = By.cssSelector("input[alt='Calculate']");
    By resultLabel = By.cssSelector("div.rightresult div b");

    public void open(){
        visit("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricTab() {
        click(metricTab);
    }

    public void clearForm() {
        click(clearBtn);
    }

    public void fillCalculatorForm(String age, String gender, String height, String weight) {
        sendKeys(ageTextbox,age);
        if(gender.toLowerCase(Locale.ROOT).equals("female")) {
            click(femaleRadioButton);
        } else if (gender.toLowerCase(Locale.ROOT).equals("male")) {
            click(maleRadioButton);
        }
        sendKeys(heightTextbox,height);
        sendKeys(weightTextbox,weight);
        click(CalculateLabel);

    }

    public String getResult() {
        return getText(resultLabel);
    }

}
