package com.cybertek.test.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultipleButtonsPageWithCSSSelector {

    String button1 = "[onclick='button1()']";
    String button2 = ".btn.btn-primary:nth-of-type(2)";
    String button3 = "[id^='button_']"; //[id='button_b1']
    String button4 = "[id$='_button'][onclick='button4()']";
    String button5 = "[onclick*='5']";
    String button6 = "#disappearing_button";
    String message = "#result";


    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();

    }
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://practice.cybertekschool.com/multiple_buttons");

    }
    @Test(priority = 1, description = "Verifying button1",enabled = true)
    public void test1(){
        driver.findElement(By.cssSelector(button1)).click();
        String expectedMessage = "Clicked on button one!";
        String actualMessage = driver.findElement(By.cssSelector(message)).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test (priority = 2,dependsOnMethods = {"test1"})
    public void test2(){
        driver.findElement(By.cssSelector(button2)).click();
        String expectedMessage = "Clicked on button two!";
        String actualMessage = driver.findElement(By.cssSelector(message)).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
//        throw new SkipException("I don't want to run this test.");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
