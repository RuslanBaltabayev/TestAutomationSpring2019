package com.cybertek.test.day5;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeXpath {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Bel Red");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("belred383@gmail.com");
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();
        SeleniumUtils.waitPlease(2);
        driver.close();

    }
}
