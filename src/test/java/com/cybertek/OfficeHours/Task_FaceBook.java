package com.cybertek.OfficeHours;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_FaceBook {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openFaceBookPage();
        //test1();
        //test2();
        //test3();
        test4();

        driver.close();
    }

    public static void openFaceBookPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
    }

    public static void test1(){

        boolean title = driver.getTitle().contains("Facebook");
        boolean url = driver.getCurrentUrl().contains("facebook.com");

        System.out.println(title);
        System.out.println(url);

    }

    public static void test2(){
       List<WebElement>  radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

       for(WebElement radioButton:radioButtons ){
           radioButton.click();
           SeleniumUtils.waitPlease(2);
           System.out.println("This button is Selectible : "+radioButton.isSelected());
           System.out.println("This button is Enable : "+radioButton.isEnabled());
       }

    }

    public static void test3(){
        WebElement femaleText = driver.findElement(By.xpath("//*[text()='Female']"));
        femaleText.click();
        SeleniumUtils.waitPlease(1);
        System.out.println("This button is Selectible : "+femaleText.isSelected());//isSelected works for only radio button
        System.out.println("This button is Enable : "+femaleText.isEnabled());
        WebElement maleText = driver.findElement(By.xpath("//*[contains(text(),'Male')]"));
        maleText.click();
        SeleniumUtils.waitPlease(1);
        System.out.println("This button is Selectible : "+maleText.isSelected());//isSelected works for only radio button
        System.out.println("This button is Enable : "+maleText.isEnabled());
        WebElement customText = driver.findElement(By.xpath("//*[text()='Custom']"));
        customText.click();
        SeleniumUtils.waitPlease(1);
        System.out.println("This button is Selectible : "+customText.isSelected());//isSelected works for only radio button
        System.out.println("This button is Enable : "+customText.isEnabled());

    }

    public static void test4(){

        WebElement SignUpButton = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        SignUpButton.click();
        System.out.println(SignUpButton.isEnabled());
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'What’s your name?')]")).isDisplayed());
        SeleniumUtils.waitPlease(1);
    }

    public static void test5(){

        WebElement warning = driver.findElement(By.xpath("//*[contains(text(),'What’s your name?')]"));
        test4();
        System.out.println(warning.isDisplayed());
    }

}
