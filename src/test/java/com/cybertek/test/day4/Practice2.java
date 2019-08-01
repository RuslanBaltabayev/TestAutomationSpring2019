package com.cybertek.test.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class Practice2 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        WebElement addElement = driver.findElement(By.linkText("Add/Remove Elements"));
        addElement.click();
        Thread.sleep(2000);
        driver.close();
    }
}
