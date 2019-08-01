package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BriteUtils {

   static WebDriver driver = Driver.getDriver();

    private static String expensesUserName = "login";
    private static String expensesPassword = "password";
    String actionButtonLocator = "//button[contains(text(),'Action')]";
    String okLocator = "//span[text()='Ok']";

    WebDriverWait wait = new WebDriverWait(driver, 10);


    public static void login(WebDriver driver,String username,String password){

        driver.findElement(By.id(expensesUserName)).sendKeys(username);
        driver.findElement(By.id(expensesPassword)).sendKeys(password, Keys.ENTER);
        SeleniumUtils.waitPlease(2);
    }

    public static void logout(WebDriver driver){
        driver.findElement(By.className("oe_topbar_name")).click();
        driver.findElement(By.xpath("//a[text()='Log out']")).click();
    }

    public static void clickTab(String tabName){
        String tablocator = "//ul[@class='nav navbar-nav navbar-left oe_application_menu_placeholder']//*[contains(text(),'"+tabName+"')]";
        WebElement tab =driver.findElement(By.xpath(tablocator));
        tab.click();
    }

    public void createOpportunity(){

    }

    public void selectOpportunity(String opportunity){
        String locator = "//td[text()='"+opportunity+"']/preceding-sibling::td//input";
        driver.findElement(By.xpath(locator)).click();
    }

    public void deleteOpportunity(String opportunity){
        selectOpportunity(opportunity);
        selectAction("Delete");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(okLocator)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(okLocator))));
        driver.findElement(By.xpath(okLocator)).click();
    }

    public void selectAction(String actionName){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actionButtonLocator))));
        driver.findElement(By.xpath(actionButtonLocator)).click();
        String optionLocator = "//a[contains(@data-section,'other') and contains(text(),'"+actionName+"')]";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(optionLocator))));
        driver.findElement(By.xpath(optionLocator)).click();
    }

    public void verifyThatOpportunityDeleted(String opportunity){
        String locator = "//td[text()='"+opportunity+"']";
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        Assert.assertTrue(elements.isEmpty());
    }

}
