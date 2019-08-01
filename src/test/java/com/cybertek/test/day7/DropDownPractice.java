package com.cybertek.test.day7;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openDropDownPage();
       // test1();
        //test2();
       // test3();
        //test4();
        //test5();
        test6();
        driver.close();

    }

    public static void openDropDownPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        SeleniumUtils.verifyIsDisplayed(element);
    }

    public static void test1(){
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        Select dropdownSelect = new Select(dropdown1);
        String expected = "Please select an option";
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        SeleniumUtils.verifyEquals(expected,actual);

        List<WebElement> options = dropdownSelect.getOptions();
        for (WebElement option:options) {
            System.out.println(option.getText());
        }


    }

    public static void test2(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropdownSelect = new Select(dropdownState);
        List<WebElement> states = dropdownSelect.getOptions();
        for(WebElement state:states){
            System.out.println(state.getText());
        }
        dropdownSelect.selectByVisibleText("Virginia");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Texas");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("California");
        SeleniumUtils.waitPlease(2);
        dropdownSelect.selectByVisibleText("Washington");
    }

    public static void test3(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropdownSelect = new Select(dropdownState);
        List<WebElement> states = dropdownSelect.getOptions();
        for(WebElement state:states){
            //SeleniumUtils.waitPlease(1);
            dropdownSelect.selectByVisibleText(state.getText());
        }
    }

    public static void test4(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropdownSelect = new Select(dropdownState);
        dropdownSelect.selectByValue("WA");
        SeleniumUtils.waitPlease(2);
        String expected = "Washington";
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        SeleniumUtils.verifyEquals(expected,actual);

    }

    public static void test5(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropdownSelect = new Select(dropdownState);
        dropdownSelect.selectByIndex(48);
        System.out.println(dropdownSelect.getFirstSelectedOption().getText());
    }

    public static void test6(){
       WebElement multipleSelectionWebElement = driver.findElement(By.xpath("//select[@name='Languages']"));
       Select multipleSelection = new Select(multipleSelectionWebElement);
       multipleSelection.selectByVisibleText("Java");
       SeleniumUtils.waitPlease(2);
       multipleSelection.selectByVisibleText("JavaScript");
        SeleniumUtils.waitPlease(2);
    }
}
