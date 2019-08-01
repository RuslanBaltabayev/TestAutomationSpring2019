package com.cybertek.pages.BriteERP;

import com.cybertek.utilities.BriteUtils;
import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Delete_Expense_Product extends TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/web/login");
    }
    @Test
    public void test(){
        BriteUtils.login(driver,"expensesmanager30@info.com","expensesmanager");
        driver.findElement(By.xpath("(//span[@class='oe_menu_text' and contains(text(),'Expenses')])[1]")).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(),'Expense Products')]")).click();
        SeleniumUtils.waitPlease(1);
        List<WebElement>allproducts = driver.findElements(By.cssSelector("div[class='oe_kanban_global_click o_kanban_record']"));
        allproducts.get(1).click();
        driver.findElement(By.xpath("//*[contains(text(),'Action')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Delete')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Ok')]")).click();
        if(driver.findElement(By.xpath("//*[contains(text(),'Access Error')]")).isDisplayed()){
            System.out.println("You don`t have permission to delete any product");
            driver.findElement(By.xpath("//span[text()='Ok']")).click();
        }

    }
    @AfterMethod
    public void tearDown(){
        BriteUtils.logout(driver);
        driver.quit();
    }
}
