package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

public class AllOrdersTests extends TestBase {





    @Test (groups = "smoke")
    public void checkAllButton(){

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        AllOrdersPage allOrdersPage = new AllOrdersPage();
        allOrdersPage.checkAllButton.click();

        for (WebElement checkbox : allOrdersPage.checkboxes) {

            Assert.assertTrue(checkbox.isSelected());
        }

    }

    @Test
    public void uncheckAllButton(){
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//table//input[@type='checkbox']"));


        for (WebElement checkbox : checkboxes) {

            Assert.assertTrue(!checkbox.isSelected());
        }

    }


    @Test (groups = "smoke")
    public void deleteSelectedButton(){
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();


        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_orderMessage")).isDisplayed());


    }
}
