package com.cybertek.test.day9;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AbsoluteXpathDemo {

    private WebDriver driver;
    String fullNameLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']";
    String emailLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']";
    String signUpButton = "html/body/div/div[2]/div/div/form/button";

    @BeforeMethod
    public void setUp(){
        driver=BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cybertekschool.com/sign_up");

    }

    @Test(priority = -1)
    public void test(){
        driver.findElement(By.xpath(fullNameLocator)).sendKeys("Bel Red");
        driver.findElement(By.xpath(emailLocator)).sendKeys("belred383@gmail.com");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath(signUpButton)).click();
        SeleniumUtils.waitPlease(1);
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.xpath("html/body/div/div[2]/div/div/h3")).getText();
        Assert.assertEquals(expected,actual);

    }
    @Test(priority = 1)
    public void negativeEmailTest(){
        String expectedLink = driver.getCurrentUrl();
        driver.findElement(By.xpath(fullNameLocator)).sendKeys("Tom Smith");
        driver.findElement(By.xpath(emailLocator)).sendKeys("email");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath(signUpButton)).click();
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(expectedLink,actualLink);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
