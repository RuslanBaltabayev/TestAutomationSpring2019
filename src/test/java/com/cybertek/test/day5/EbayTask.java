package com.cybertek.test.day5;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EbayTask {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[]args){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java", Keys.ENTER);
        SeleniumUtils.waitPlease(1);
        System.out.println(driver.findElement(By.className("srp-controls__count-heading")).getText());
        driver.close();
        }

}
