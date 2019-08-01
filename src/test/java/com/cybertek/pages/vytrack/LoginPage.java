package com.cybertek.pages.vytrack;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;

public class LoginPage {
    String userNameLocater = "prependedInput";
    String passwordLocator = "prependedInput2";
    String loginButtonLocator = "_submit";

    public void login(String userName,String password){
        Driver.getDriver().findElement(By.id(userNameLocater)).sendKeys(userName);
        Driver.getDriver().findElement(By.id(passwordLocator)).sendKeys(password);
        Driver.getDriver().findElement(By.id(loginButtonLocator)).click();
    }
}
