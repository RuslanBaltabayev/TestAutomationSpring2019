package com.cybertek.test.day8_TestNG_Intro;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestNG_Task1 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){

      WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("http://practice.cybertekschool.com");
        SeleniumUtils.waitPlease(2);

    }

    @BeforeMethod
    public void setUp(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        SeleniumUtils.waitPlease(2);
    }

    @Test
    public void test1(){
        WebElement year = driver.findElement(By.id("year"));
        Select dropdownSelectYear = new Select(year);
        String actualYear  = dropdownSelectYear.getFirstSelectedOption().getText();
        String expectedYear = "2019";

        WebElement month = driver.findElement(By.id("month"));
        Select dropdownSelectMonth = new Select(month);
        String actualMonth = dropdownSelectMonth.getFirstSelectedOption().getText();
        String expectedMonth = "July";

        WebElement day = driver.findElement(By.id("day"));
        Select dropdownSelectDay = new Select(day);
        int actualDay = Integer.parseInt(dropdownSelectDay.getFirstSelectedOption().getText());
        int expectedDay = 7;

        Assert.assertEquals(expectedYear,actualYear);
        Assert.assertEquals(expectedMonth,actualMonth);
        Assert.assertEquals(expectedDay,actualDay);

        SeleniumUtils.waitPlease(2);

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

}
