package com.cybertek.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Task2 {
    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://amazon.com");
       boolean isContainSale = driver.getTitle().contains("sale");
       if(isContainSale)
           System.out.println("verified");
       else
           System.out.println("not-verified");
       driver.quit();
    }
}
