package com.cybertek.pages.BriteERP;

import com.cybertek.utilities.BriteUtils;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpportunitiesList extends TestBase {

    WebDriver driver = Driver.getDriver();


    @Test
    public void test(){
       BriteUtils.login(driver,"eventscrmmanager46@info.com","eventscrmmanager");

       BriteUtils.clickTab("CRM");

       driver.findElement(By.cssSelector("button[accesskey='l']")).click();
       SeleniumUtils.waitPlease(1);

        String numberOpportunities1 = "o_pager_limit";
        WebElement numOpportunityElement = driver.findElement(By.className(numberOpportunities1));
        int NumOpp1 = Integer.valueOf(numOpportunityElement.getText());
        System.out.println(NumOpp1);

        String createBtn = "button[class='btn btn-primary btn-sm o_list_button_add']";
        driver.findElement(By.cssSelector(createBtn)).click();
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Lexus");
        driver.findElement(By.xpath("//input[@class='o_input']"));
        driver.findElement(By.cssSelector("button[accesskey='s']")).click();
        driver.findElement(By.cssSelector("button[accesskey='c']")).click();
        driver.findElement(By.cssSelector("button[accesskey='j']")).click();
        SeleniumUtils.waitPlease(1);

        String numberOpportunities2 = "o_pager_limit";
        WebElement numOpportunityElement2 = driver.findElement(By.className(numberOpportunities2));
        int NumOpp2 = Integer.valueOf(numOpportunityElement2.getText());
        System.out.println(NumOpp2);
        Assert.assertTrue(NumOpp2>NumOpp1,"Did not created");


        driver.findElement(By.cssSelector("body > div.o_main > div.o_main_content > div.o_content > div > div > div > table > tbody > tr:nth-child(1) > td.o_list_record_selector > div > input[type=checkbox]")).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath("(//span[@class='caret'])[2]")).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/ul/li[4]")).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector("button[class='btn btn-sm btn-primary']")).click();
        SeleniumUtils.waitPlease(1);

        String numberOpportunities3 = "o_pager_limit";
        WebElement numOpportunityElement3 = driver.findElement(By.className(numberOpportunities3));
        int NumOpp3 = Integer.valueOf(numOpportunityElement3.getText());
        System.out.println(NumOpp3);

        Assert.assertTrue(NumOpp2>NumOpp3,"Did not deleted");


       BriteUtils.logout(driver);


    }




}




