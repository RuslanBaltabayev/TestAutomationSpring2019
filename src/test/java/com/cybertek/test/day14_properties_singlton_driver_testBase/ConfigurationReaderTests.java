package com.cybertek.test.day14_properties_singlton_driver_testBase;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigurationReaderTests {

    @Test
    public void test1(){
        String excpected ="chrome";
        String actual = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actual,excpected);

    }
    @Test
    public void tests2(){
        String expectedUserName = "storemanager85";
        String actualUserName = ConfigurationReader.getProperty("username");
        Assert.assertEquals(actualUserName,expectedUserName);
    }
}
