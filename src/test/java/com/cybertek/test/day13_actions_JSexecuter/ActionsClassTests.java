package com.cybertek.test.day13_actions_JSexecuter;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsClassTests {

    WebDriver driver;
    String user1TextLocator = "//h5[contains(text(),'user1')]";
    String firstImageLocator = "(//img)[1]";
    String enabledOptionLocator = "#ui-id-3";
    String downloadsOptionLocator = "//a[contains(text(),'Downloads')]";
    String pdfOptionLocator = "//a[contains(text(),'PDF')]";
    String moonLocator = "draggable";
    String earthLocator = "droptarget";

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void hoverTest1(){
        driver.get("http://practice.cybertekschool.com/hovers");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(firstImageLocator))).perform();
        String expectedText = "name: user1";
        String actualText = driver.findElement(By.xpath(user1TextLocator)).getText();
        Assert.assertEquals(expectedText,actualText);

    }
@Test
    public void hoverTest2(){
        driver.get("http://practice.cybertekschool.com/hovers");
        Actions action = new Actions(driver);
        List<WebElement>images = driver.findElements(By.tagName("img"));
        for(WebElement image:images){
            SeleniumUtils.waitPlease(1);
            action.moveToElement(image).perform();
        }
    }
@Test
    public void hoverTest3(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Actions action = new Actions(driver);
        WebElement enabledElement = driver.findElement(By.cssSelector(enabledOptionLocator));
        WebElement downloadElement = driver.findElement(By.xpath(downloadsOptionLocator));
        WebElement pdfElement = driver.findElement(By.xpath(pdfOptionLocator));
        action.moveToElement(enabledElement).pause(1000).
                moveToElement(downloadElement).pause(1000).
                moveToElement(pdfElement).pause(1000).click().build().perform();
        SeleniumUtils.waitPlease(2);

    }
    @Test
    public void dragAndDropTest1(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions action = new Actions(driver);
        WebElement moon = driver.findElement(By.id(moonLocator));
        WebElement earth = driver.findElement(By.id(earthLocator));

        action.dragAndDrop(moon,earth).perform();
        String expected="You did great!";
        String actual = earth.getText();
        Assert.assertEquals(expected,actual);
        SeleniumUtils.waitPlease(3);
    }
    @AfterMethod
    public void tearDown(){
       driver.quit();
    }
}
