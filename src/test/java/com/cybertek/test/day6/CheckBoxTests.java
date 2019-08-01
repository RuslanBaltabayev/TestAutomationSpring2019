package com.cybertek.test.day6;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openCheckBoxesPage();
        test1();
        driver.close();

    }

    public static void test1(){
       WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if(!checkbox1.isSelected())
            System.out.println("Passed");
        else
            System.out.println("Failed");

        if(checkbox2.isSelected())
            System.out.println("Passed");
        else
            System.out.println("Failed");



    }

    public static void openCheckBoxesPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement logo = driver.findElement(By.tagName("h3"));

        if(logo.isDisplayed())
            System.out.println("Checkbox logo is visible");
        else
            System.out.println("Checkbox logo does not found");
    }
}
