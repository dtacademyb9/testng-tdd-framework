package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class OrderDetailsTests extends TestBase{



    @Test
    public void test1(){


        List<String> expectedProducts = Arrays.asList("MyMoney", "FamilyAlbum" , "ScreenSaver");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);
        driver.findElement(By.linkText("View all products")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td[1]"));

        List<String> actualProducts = SeleniumUtils.getElementsText(elements);

        Assert.assertEquals(actualProducts, expectedProducts);



    }



}
