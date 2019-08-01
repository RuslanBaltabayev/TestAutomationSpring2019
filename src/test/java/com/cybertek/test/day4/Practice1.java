package com.cybertek.test.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        WebElement googleSearchButton = driver.findElement(By.className("gNO89b"));
        //googleSearchButton.submit();
        System.out.println(googleSearchButton.getAttribute("value"));
        System.out.println(googleSearchButton.getAttribute("aria-label"));
        System.out.println(googleSearchButton.getAttribute("name"));
        System.out.println(googleSearchButton.getAttribute("type"));

        WebElement americaSearchingToday = driver.findElement(By.className("NKcBbd"));
        String americaSearchLink = americaSearchingToday.getAttribute("href");
        driver.navigate().to(americaSearchLink);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.close();



    }
}
