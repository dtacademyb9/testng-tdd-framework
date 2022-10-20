package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {


    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupMethod(){
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }




    @Test (groups = "smoke")
    public void loginPositive(){
         driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
         Assert.assertEquals(driver.getTitle(), "Web Orders");
    }

    @Test (groups = "smoke")
    public void loginNegativeBadCredentials(){
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Blaba", Keys.TAB, "blala", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
    }


    @Test
    public void loginNegativeNoCredentials(){
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
    }



    @Test
    public void loginNegativeWrongPass(){
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "dsjajdsj", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
    }

    @Test
    public void loginNegativeWrongUsername(){
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Donald Duck", Keys.TAB, "test", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
    }

    @Test (groups = "smoke")
    public void loginMessage(){
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Donald Duck", Keys.TAB, "donald", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_status")).isDisplayed());
    }



}
