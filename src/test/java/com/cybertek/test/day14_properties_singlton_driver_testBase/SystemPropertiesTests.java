package com.cybertek.test.day14_properties_singlton_driver_testBase;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class SystemPropertiesTests {

    @Test
    public void systemPropertiesTest1(){
        String os = System.getProperty("os.name");
        System.out.println("os.name --->"+os);
        String username = System.getProperty("user.name");
        System.out.println("user.name --->"+username);
        String javaVersion = System.getProperty("java.version");
        System.out.println("java.version --->"+javaVersion);
        String homeDirectory = System.getProperty("user.home");
        System.out.println("user home --->"+homeDirectory);

        Properties properties = System.getProperties();
        for(Map.Entry<Object,Object>property:properties.entrySet()){
            System.out.println("Keys: "+property.getKey()+", Value: "+property.getValue());
        }
    }
}
