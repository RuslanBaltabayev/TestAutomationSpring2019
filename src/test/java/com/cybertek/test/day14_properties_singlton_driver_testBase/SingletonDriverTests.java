package com.cybertek.test.day14_properties_singlton_driver_testBase;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SeleniumUtils;
import org.testng.annotations.Test;

public class SingletonDriverTests {
    @Test
    public void test1(){
        Driver.getDriver().get("http://google.com");
        SeleniumUtils.waitPlease(2);
        Driver.closeDriver();
    }
}
