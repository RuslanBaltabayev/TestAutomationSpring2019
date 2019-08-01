package com.cybertek.test.day13_actions_JSexecuter;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptEXecutotTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/");
        JavascriptExecutor js =(JavascriptExecutor) driver;
        String title=(String) js.executeScript("return document.title");
        js.executeScript("alert('HELLO SPARTANTS!')");
        SeleniumUtils.waitPlease(3);
        Alert alert =driver.switchTo().alert();
        alert.accept();
        SeleniumUtils.waitPlease(3);
        System.out.println(title);
    }
@Test
    public void ScrollTest1() {
    driver.get("http://practice.cybertekschool.com/infinite_scroll");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    for (int i = 0; i < 11; i++) {
        js.executeScript("window.scrollBy(0,500)");
        SeleniumUtils.waitPlease(1);
    }
}
       @Test
        public void ScrollTest2() {
        driver.get("http://practice.cybertekschool.com/");
        WebElement footerLink = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        SeleniumUtils.waitPlease(2);
        js.executeScript("arguments[0].scrollIntoView(true)",footerLink);
        SeleniumUtils.waitPlease(2);
        js.executeScript("arguments[0].click()",footerLink);
        SeleniumUtils.waitPlease(2);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
