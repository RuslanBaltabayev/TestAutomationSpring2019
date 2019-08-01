package com.cybertek.test.day14_properties_singlton_driver_testBase;

import com.cybertek.pages.vytrack.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void LoginTest1(){
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username,password);
    }


}
