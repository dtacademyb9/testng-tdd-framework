package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.List;

public class PlaceOrderPage {


    public PlaceOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "ctl00$MainContent$fmwOrder$ddlProduct")
    public WebElement productDropdown;

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtQuantity")
    public WebElement quantity;

    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement calculateButton;

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtName")
    public WebElement customer;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox2")
    public WebElement street;


    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox3")
    public WebElement city;


    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox4")
    public WebElement state;


    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox5")
    public WebElement zip;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> radioButtons;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox6")
    public WebElement cardNo;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox1")
    public WebElement expiryDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement proceedButton;

    @FindBy(tagName = "strong")
    public WebElement successMessage;












    public void enterRandomData(){
        Faker faker = new Faker();

        customer.sendKeys(faker.name().fullName());
        street.sendKeys(faker.address().streetAddress());
        city.sendKeys(faker.address().city());
        state.sendKeys(faker.address().state());
        zip.sendKeys("22345");
    }

    public void enterData(String fullName, String address, String city1, String state1, String zip1){

        customer.sendKeys(fullName);
        street.sendKeys(address);
        city.sendKeys(city1);
        state.sendKeys(state1);
        zip.sendKeys(zip1);
    }

    public void enterCardDetails(){

        cardNo.sendKeys(new Faker().business().creditCardNumber().replace("-", ""));
        expiryDate.sendKeys("12/33");
    }




    public void chooseAProduct(String productName){
        new Select(productDropdown).selectByVisibleText(productName);
    }
}
