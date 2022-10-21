package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){

        if(driver == null){

            String browser = ConfigReader.getProperty("browser");

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver =  new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver =  new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver =  new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported Browser");

            }


        }

        return driver;




    }


    public static void quitDriver(){

        if(driver != null){
            driver.quit();
            driver = null;
        }
    }





}
