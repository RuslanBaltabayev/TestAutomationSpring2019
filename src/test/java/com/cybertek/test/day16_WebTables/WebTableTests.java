package com.cybertek.test.day16_WebTables;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTableTests extends TestBase {

    @Test(priority = 1)
    public void printTableTest(){
        WebElement table = driver.findElement(By.id("table1"));
        //table will give us whole table including header
        System.out.println(table.getText());
        //table.getText() will print all table data
    }
    @Test(priority = 2)
    public void printHeaderRow(){
       WebElement header = driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
       //we can use nested findelement...
       // WebElement header = driver.findElement(By.xpath("//table[1]//thead"));
        System.out.println(header.getText());
        //will print row of the headers
    }
    @Test(priority = 3)
    public void countRowsTest(){
        //css locator
       String locator = "table[id='table1']> tbody tr";
       //xpath locator
       // String locator = "//table[1]//tbody//tr";
        List<WebElement>rows = driver.findElements(By.cssSelector(locator));
        //will print row size
        System.out.println("Size: "+rows.size());
    }
    @Test(priority = 4)
    public void countRowsTest2(){
        String locator = "#table2 tr";
        List<WebElement>rows = driver.findElements(By.cssSelector(locator));
        Assert.assertEquals(rows.size(),5);
    }
    @Test(priority = 5)
    public void printTableHeaders(){
        String locator = "#table1 th";

        List<WebElement>headers = driver.findElements(By.cssSelector(locator));
        for(WebElement header:headers){
            System.out.println(header.getText());
        }

    }
    @Test(priority = 6)
    public void printSpecificRow(){
        int row =3;
        String locator = "//table[1]//tbody//tr["+row+"]";

        WebElement rowElement = driver.findElement(By.xpath(locator));
        System.out.println(rowElement.getText());
    }
    //let's write a method that will return column based on column name

    @Test(priority = 7)
    public void printColumnTest(){
        System.out.println(getColumn("Email"));
    }

    @Test(priority = 8)
    public void verifyThatNameDisplays(){
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";

        String actualName = driver.findElement(By.xpath(firstNameLocator)).getText();
        String actualLastName = driver.findElement(By.xpath(lastNameLocator)).getText();

        Assert.assertEquals(actualName, firstName);
        Assert.assertEquals(actualLastName, lastName);
    }

    @Test(priority= 9,dependsOnMethods = "verifyThatNameDisplays")
    public void verifyThatRecordHasBeenDeletedTest(){
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";

        String target = "//table[1]//td[text()='"+lastName+"']";

        String deleteLocator = "//table[1]//td[text()='"+lastName+"']/following-sibling::td//a[text()='delete']";

        driver.findElement(By.xpath(deleteLocator)).click();

        Assert.assertTrue(driver.findElements(By.xpath(target)).isEmpty());
    }



    public List<String> getColumn(String columnName){

        List<String> values = new ArrayList<>();
        //all headings
        List<WebElement> headings = driver.findElements(By.xpath("//table[1]//th"));
        int columnNumber = 0;
        //we are looping though collection of headings
        for(int i =0; i< headings.size();i++){
            //we are looking for position of heading
            if(headings.get(i).getText().equals(columnName)){
                columnNumber = i+1;
                break;
            }
        }
        //based on position that we found in previous loop, we allocating column
        List<WebElement> columnList = driver.findElements(By.xpath("//table[1]//tr//td["+columnNumber+"]"));

        for(WebElement columnValue: columnList){
            values.add(columnValue.getText());
        }

        return values;

    }
}
