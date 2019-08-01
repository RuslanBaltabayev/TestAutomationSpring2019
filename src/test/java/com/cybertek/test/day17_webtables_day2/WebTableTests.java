package com.cybertek.test.day17_webtables_day2;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WebTableTests extends TestBase {

    WebDriver driver = Driver.getDriver();
    /*
      #table1-->whole table
       tbody-->whole body
      #table1 tbody -->whole table(without headers)
      #table1 thead --> all header line
      #table1 th-->headers
      #table1 tr -->rows
      #table1 td-->each element in rows(same)
      //table[1]-->all table
      //table[1]//tbody-->whole body(without header)
      //table[1]//tbody//tr -->rows one by one(without header)
      //table[1]//tbody//tr[1] -->1st row
      //table[1]//tbody//tr[2] -->2st row
      //table[1]//tbody//tr//td[1]-->1st column each
      //table[1]//tbody//tr//td[2]-->2st column each
      //table[1]//tbody//tr//td -->each element of the table goes one by one through all cells

     */




    //write the method that will count of the rows
    // tr--> shows the number of rows

    public int getCountOfRows(){

        return driver.findElements(By.cssSelector("#table1 tr")).size();
    }

    //overload of the method
    public int getCountOfRows(By by ){

        return driver.findElements(by).size();
    }

    @Test
    public void countOfRowsTest1(){
        Assert.assertEquals(getCountOfRows(),5,"Number of rows doesn`t match");
    }
    @Test
    public void countOfRowsTest2(){
        Assert.assertEquals(getCountOfRows(By.cssSelector("#table1 tr")),5,"Number of rows doesn`t match");
    }

    //Write a method that returns  number of columns


    public int getCountOfColumns(){
        return driver.findElements(By.cssSelector("#table1 th")).size();
    }
    //overload method
    public int getCountOfColumns(By by){
        return driver.findElements(by).size();
    }
    @Test
    public void countOfColumnsTest1(){
        Assert.assertEquals(getCountOfColumns(),6,"Number of columns doesn`t match");
    }
    @Test
    public void countOfColumnsTest2(){
        Assert.assertEquals(getCountOfColumns(By.xpath("//table[1]//th")),6,"Number of columns doesn`t match");
    }

    //write a method that will return table size

    public int[] getTableSize(){
        int[] size ={getCountOfRows(),getCountOfColumns()};
        return size;
    }

    public int[] getTableSize(By rowLocator, By columnLocator){
        int[] size ={getCountOfRows(rowLocator),getCountOfColumns(columnLocator)};
        return size;
    }
    @Test
    public void countOfTableTest1(){
        int[] expectedSize = {5,6};
        int [] actualSize = getTableSize();
        Assert.assertEquals(actualSize,expectedSize,"Number of row or column don`t match");
    }
    @Test
    public void countOfTableTest2(){
        int[] expectedSize = {5,6};
        int [] actualSize = getTableSize((By.xpath("//table[1]//tr")),By.xpath("//table[1]//th"));
        Assert.assertEquals(actualSize,expectedSize,"Number of row or column don`t match");
    }

    //write a method that will return table header(column names) as a list of webelement

    public List<WebElement> getHeaders(){
        return driver.findElements(By.cssSelector("#table1 th"));
    }
//method returns table headers list as a string
    public List<String> getHeadersText(){
        List<String> headers = new ArrayList<>();
        for(WebElement tableHeader:getHeaders()){
            headers.add(tableHeader.getText());
        }
        return headers;
    }
    @Test
    public void getHeadersTest(){
        List<String> expectedColumnNames = Arrays.asList("Last Name","First Name","Email","Due","Web Site","Action");
        Assert.assertEquals(getHeadersText(),expectedColumnNames,"Column names don`t match");

    }

    //Let's write a test
    //to verify if first name column is sorted in alphabetic order
    @Test
    public void sortColumnTest(){
        String columnName = "First Name";
        driver.findElement(By.xpath("//table[1]//th//span[text()='"+columnName+"']")).click();
        //create list to compare
        List<String> sorted = new ArrayList<>();
        //add everything to the list
        sorted.addAll(getColumnData(columnName));
        //sort it with Collections.sort()
        Collections.sort(sorted);
        //Compare if sorted list is the same as before sorting
        Assert.assertEquals(getColumnData(columnName), sorted);
    }
    public List<String> getColumnData(String columnName){
        int columnNumber = 0;
        for (int i=0; i < getCountOfColumns(); i++){
            if(columnName.equals(getHeadersText().get(i))){
                columnNumber = i + 1;
            }
        }
        String locatorForColumn = "//table[1]//tbody//tr//td["+columnNumber+"]";
        //this is a collection of web elements that contains values from specific column
        List<WebElement> columnCollectionOfWebElements = driver.findElements(By.xpath(locatorForColumn));
        List<String> columnCollectionOfText = new ArrayList<>();
        for (WebElement element: columnCollectionOfWebElements){
            columnCollectionOfText.add(element.getText());
        }
        return columnCollectionOfText;
    }
}
