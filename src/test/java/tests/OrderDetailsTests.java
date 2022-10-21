package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;

public class OrderDetailsTests extends TestBase{



    @Test
    public void test1(){

       driver.manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Assert.assertTrue( Driver.getDriver().getTitle().contains("Web Order"));
    }



}
