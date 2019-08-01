package com.cybertek.test.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();//replaces System.setProperty();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.id("form_submit"));
        Thread.sleep(2000);
        emailInputBox.sendKeys("belred383@gmail.com");
        System.out.println(emailInputBox.getAttribute("pattern"));
        System.out.println(emailInputBox.getAttribute("value"));
        submitButton.submit();
        Thread.sleep(2000);
        driver.close();

    }
}
