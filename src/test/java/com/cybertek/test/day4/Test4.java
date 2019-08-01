package com.cybertek.test.day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Test4 {
    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();
    }
}
