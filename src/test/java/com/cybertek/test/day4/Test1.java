package com.cybertek.test.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();//replaces System.setProperty();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.id("form_submit"));
        Thread.sleep(2000);
        emailInputBox.sendKeys("tomsmith@gmail.com");
        submitButton.click();
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationMessage.getText();
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
            System.out.println("Expected message "+expectedMessage);
            System.out.println("Actual message "+actualMessage);
        }
        Thread.sleep(2000);
        driver.close();

    }
}
