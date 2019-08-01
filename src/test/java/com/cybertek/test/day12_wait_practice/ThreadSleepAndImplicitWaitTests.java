package com.cybertek.test.day12_wait_practice;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepAndImplicitWaitTests {

    String helloWorldMessageLocator ="#finish > h4";
    String startButtonLocator = "#start>button";

    WebDriver driver;

 @BeforeMethod
    public void setUp(){
      driver = BrowserFactory.getDriver("chrome");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

  @Test
    public void waitTest(){
      driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
        String expectedMessage = "Hello World!";
        //SeleniumUtils.waitPlease(4);
        String actualMessage = driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void waitTest2(){
     driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
    String expectedMessage = "Hello World!";
    String actualMessage = driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();
    Assert.assertEquals(expectedMessage,actualMessage);

    }
  @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
