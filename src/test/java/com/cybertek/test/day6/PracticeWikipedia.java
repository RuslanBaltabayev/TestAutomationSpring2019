package com.cybertek.test.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PracticeWikipedia {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://wikipedia.org");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("selenium webdriver", Keys.ENTER);
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        SeleniumUtils.waitPlease(1);
        if(driver.getCurrentUrl().endsWith("x")){
            System.out.println("URL ends with x");
        }else{
            System.out.println("URL does not end with x");

        }
        SeleniumUtils.waitPlease(1);
        driver.quit();


    }


}
