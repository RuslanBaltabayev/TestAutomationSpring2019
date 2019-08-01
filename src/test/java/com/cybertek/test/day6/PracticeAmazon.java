package com.cybertek.test.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PracticeAmazon {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphoneXSMax", Keys.ENTER);
        String actual = driver.getTitle();
        String expected = "iphone";

        if(driver.getTitle().contains("iphone")){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
        }
        SeleniumUtils.waitPlease(1);
        driver.close();
    }
}
