package com.cybertek.test.day12_wait_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitTests {

    String startButtonLocator = "#start>button";
    String userNameLocator = "input[type='username']";
    String passwordLocator = "input[type='password']";
    String submitButtonLocator = "button[type='submit']";
    String loading = "div[id='loading']";

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
    @Test
    public void waitForVisibilityTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
        System.out.println(driver.findElement(By.cssSelector(loading)).getText());
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(userNameLocator))));
        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.cssSelector(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.cssSelector(submitButtonLocator)).click();
       // String expectedMessage = "";
       // String actualMessage = driver.findElement(By.cssSelector())

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
