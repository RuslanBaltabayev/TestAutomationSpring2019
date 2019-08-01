package com.cybertek.test.day5;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeTagName {

    //TASK: FIND ALL BUTTONS,PUT THEM IN THE LIST,AND CLICK ON THEM ONE BY ONE

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void test1(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Size: "+buttons.size());
        for(WebElement button:buttons){
            System.out.println(button.getText());
            button.click();
            SeleniumUtils.waitPlease(1);

        }
        driver.close();


    }

    public static void main(String[] args)  {
        test1();


    }
}
