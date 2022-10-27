package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Properties;

public class LoginTests extends TestBase{

    LoginPage loginPage;

    @Test (groups = "smoke")
    public void loginPositive() throws IOException {


        loginPage = new LoginPage();
        logger.info("Entering the valid credentials and logging in");
        loginPage.login(ConfigReader.getProperty("username")+"dshb", ConfigReader.getProperty("password"));

        logger.info("Verifying the title");
        Assert.assertEquals(driver.getTitle(), "Web Orders");



    }

    @Test (groups = "smoke")
    public void loginNegativeBadCredentials(){

        System.out.println(System.getProperty("browser"));
        loginPage = new LoginPage();
        loginPage.login("Blaba", "blala");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
    }


    @Test
    public void loginNegativeNoCredentials(){
        loginPage = new LoginPage();
        loginPage.login("","");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
    }



    @Test
    public void loginNegativeWrongPass(){

        loginPage = new LoginPage();
        loginPage.login(ConfigReader.getProperty("username"), "dsjajdsj");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
    }

    @Test
    public void loginNegativeWrongUsername(){

        loginPage = new LoginPage();
        loginPage.login("Donald Duck", ConfigReader.getProperty("password"));
        Assert.assertEquals(driver.getTitle(), "Web Orders Logins");
    }

    @Test (groups = "smoke")
    public void loginMessage(){
        loginPage = new LoginPage();
        loginPage.login("Donald Duck","donald");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }



}
