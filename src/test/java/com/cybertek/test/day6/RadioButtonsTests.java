package com.cybertek.test.day6;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonsTests {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        //test1();
        //test2();
        test4();
    }

    public static  void openRadioButtonPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    public static  void test1(){
        openRadioButtonPage();
        if(driver.findElement(By.id("blue")).isSelected()){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        driver.close();
    }
    public static void test2(){
        openRadioButtonPage();
        if(driver.findElement(By.id("black")).isEnabled()&&!driver.findElement(By.id("green")).isEnabled()){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.close();
    }
    public static void test4(){
        openRadioButtonPage();

        List<WebElement>listOfRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

        int counter = 0;
        for(WebElement radioButton:listOfRadioButtons){
            if(radioButton.isSelected()) {
                System.out.println(radioButton.getAttribute("id"));
                counter++;
            }
        }
        System.out.println(counter);
        driver.close();
    }

}
