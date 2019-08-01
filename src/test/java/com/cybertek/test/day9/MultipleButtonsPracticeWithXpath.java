package com.cybertek.test.day9;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleButtonsPracticeWithXpath {

    WebDriver driver;
    String buttonAll ="//button[starts-with(@onclick,'button')]";
    String button1Loctator = "//button[.='Button 1']";
    String button2Locator = "//button[contains(.,'Button 2')]";
    String button3Locator ="//button[starts-with(@id,'button_')]";
    String button4Locator = "//button[contains(text(),'4')]";
    String button5Locator = "//button[5]";
    String buttonLast = "//button[@id='disappearing_button']";
    String resultLocator = "//p[@id='result']";


    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://practice.cybertekschool.com/multiple_buttons");

    }
    @Test (priority = 1)
    public void verifyButton3(){
        String expectedMessage = "Clicked on button three!";
        driver.findElement(By.xpath(button3Locator)).click();
        SeleniumUtils.waitPlease(1);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test(priority = 2)
    public void verifyButton4(){
        String expectedMessage = "Clicked on button four!";
        driver.findElement(By.xpath(button4Locator)).click();
        SeleniumUtils.waitPlease(1);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(expectedMessage,actualMessage);


    }
    @Test(priority = 3)
    public void verifyButtonLast(){
        String expectedMessage = "Now it's gone!";
        driver.findElement(By.xpath(buttonLast)).click();
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        //Assert.assertTrue(driver.findElement(By.xpath(buttonLast)).isDisplayed()); //will fail
        Assert.assertTrue(driver.findElements(By.xpath(buttonLast)).size()==0);
    }
    @Test(priority = 0)
    public void allButton(){
        List<WebElement>buttons = driver.findElements(By.xpath(buttonAll));
        for(WebElement button:buttons){
            button.click();
            SeleniumUtils.waitPlease(1);
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
