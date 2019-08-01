package com.cybertek.test.day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();//replaces System.setProperty();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox = driver.findElement(By.name("email"));
        Thread.sleep(2000);
        Faker faker = new Faker();
        emailInputBox.sendKeys(faker.firstName());
        Thread.sleep(2000);
        emailInputBox.clear();
        Thread.sleep(2000);
        emailInputBox.sendKeys("belred383@gmail.com"+Keys.ENTER);
        Thread.sleep(2000);
        driver.close();

    }
}
