package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class LoginPage {


     // Page Factory design pattern
     // Use @FindBy annotations to locate the webelements

     public LoginPage(){
          PageFactory.initElements(Driver.getDriver(),this); // initialize Webelements with @FindBy annotations
     }


  // Page Object Model without PageFactory
//     public WebElement usernameField =  Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
//     public WebElement errorMessage =  Driver.getDriver().findElement(By.id("ctl00_MainContent_status"));

     @FindBy (id = "ctl00_MainContent_username")
     public WebElement usernameField;

     @FindBy (id = "ctl00_MainContent_status")
     public WebElement errorMessage;


     public void login(String user, String pass){
          usernameField.sendKeys(user, Keys.TAB, pass, Keys.ENTER);
     }

     public void login(){
          usernameField.sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);
     }






}
