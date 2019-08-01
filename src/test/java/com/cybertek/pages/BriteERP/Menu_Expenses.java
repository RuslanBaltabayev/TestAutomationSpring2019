package com.cybertek.pages.BriteERP;

import com.cybertek.utilities.BriteUtils;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Menu_Expenses {

    WebDriver driver= Driver.getDriver();

    @BeforeMethod
 public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/web/login");
 }
@Test
 public void menu_expenses(){
     BriteUtils.login(driver,"expensesmanager30@info.com","expensesmanager");
     driver.findElement(By.xpath("(//span[@class='oe_menu_text' and contains(text(),'Expenses')])[1]")).click();
     driver.findElement(By.xpath("//button[contains(text(),'Creat')]")).click();
     driver.findElement(By.cssSelector("input[class='o_field_char o_field_widget o_input o_required_modifier']")).sendKeys("iphone8");
    SeleniumUtils.waitPlease(1);

    WebElement select = driver.findElement(By.xpath("(//input[@class='o_input ui-autocomplete-input'])[1]"));
    select.click();
    SeleniumUtils.waitPlease(1);
    select.sendKeys(Keys.DOWN);
    SeleniumUtils.waitPlease(1);
    select.sendKeys(Keys.UP);
    SeleniumUtils.waitPlease(1);
    select.sendKeys(Keys.ENTER);
     SeleniumUtils.waitPlease(1);
     WebElement select1 =  driver.findElement(By.xpath("(//input[@class='o_input ui-autocomplete-input'])[4]"));
     select1.click();
     SeleniumUtils.waitPlease(1);
     select1.sendKeys(Keys.DOWN);
     SeleniumUtils.waitPlease(1);
     select1.sendKeys(Keys.DOWN);
     SeleniumUtils.waitPlease(1);
     select1.sendKeys(Keys.ENTER);
     SeleniumUtils.waitPlease(1);
     driver.findElement(By.cssSelector("button[class='btn btn-primary btn-sm o_form_button_save']")).click();
     SeleniumUtils.waitPlease(1);
     driver.findElement(By.cssSelector("button[class='btn btn-default btn-sm o_form_button_create']")).click();
     String expected = "New";
     String actual = driver.findElement(By.xpath("//li[text()='New']")).getText();
    Assert.assertEquals(expected,actual);

 }
@AfterMethod
 public void tearDown(){
    BriteUtils.logout(driver);
        SeleniumUtils.waitPlease(1);
        driver.quit();
 }

}
