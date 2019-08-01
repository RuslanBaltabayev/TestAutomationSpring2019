package com.cybertek.pages.BriteERP;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;

public class LoginPage {

    String usernameLocatorID = "login";
    String passwordLocatorID = "password";
    String submitBtnLocatorXPATH = "//*[text()='Log in']";

    public void login(){
        Driver.getDriver().findElement(By.id(usernameLocatorID)).sendKeys("expensesmanager30@info.com");
        Driver.getDriver().findElement(By.id(passwordLocatorID)).sendKeys("expensesmanager");
        Driver.getDriver().findElement(By.xpath(submitBtnLocatorXPATH)).click();

    }




}
