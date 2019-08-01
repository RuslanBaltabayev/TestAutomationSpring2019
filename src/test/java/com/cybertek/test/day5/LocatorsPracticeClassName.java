package com.cybertek.test.day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeClassName {

    //assignment: Get list of examples based on the class name "list-group-item"
    //then use for loop to get every element and print the text of this elements
    //check how many elements you will get ,it must be 48

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
        List<WebElement> list = driver.findElements(By.className("list-group-item"));
        System.out.println("Size: "+list.size());
        for(WebElement each:list){
            System.out.println(each.getText());
        }

        driver.close();

    }


}
