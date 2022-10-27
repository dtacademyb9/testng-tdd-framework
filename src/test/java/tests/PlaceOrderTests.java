package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;
import pages.PlaceOrderPage;
import utils.CSVReader;

import java.util.Random;

public class PlaceOrderTests extends TestBase{

    @Test
    public void placeOrderRandomData() throws InterruptedException {

        new LoginPage().login();

        new AllOrdersPage().orderLink.click();

        PlaceOrderPage placeOrderPage = new PlaceOrderPage();

        placeOrderPage.chooseAProduct("FamilyAlbum");

        placeOrderPage.quantity.sendKeys(Keys.BACK_SPACE, (1+new Random().nextInt(100))+"");

        placeOrderPage.calculateButton.click();

        placeOrderPage.enterRandomData();

        placeOrderPage.radioButtons.get(new Random().nextInt(placeOrderPage.radioButtons.size())).click();

        placeOrderPage.enterCardDetails();

        placeOrderPage.proceedButton.click();

        Assert.assertTrue(placeOrderPage.successMessage.isDisplayed());


    }

    @Test (dataProvider = "customers")
    public void placeOrderDataFromCSVFile(String fullName, String address, String city1, String state1, String zip1) throws InterruptedException {

        new LoginPage().login();

        new AllOrdersPage().orderLink.click();

        PlaceOrderPage placeOrderPage = new PlaceOrderPage();

        placeOrderPage.chooseAProduct("FamilyAlbum");

        placeOrderPage.quantity.sendKeys(Keys.BACK_SPACE, (1+new Random().nextInt(100))+"");

        placeOrderPage.calculateButton.click();

        placeOrderPage.enterData(fullName, address,city1,state1,zip1);

        placeOrderPage.radioButtons.get(new Random().nextInt(placeOrderPage.radioButtons.size())).click();

        placeOrderPage.enterCardDetails();

        placeOrderPage.proceedButton.click();

        Assert.assertTrue(placeOrderPage.successMessage.isDisplayed());


    }


    @DataProvider (name = "customers")
    public Object[][] getData(){
        return CSVReader.readFromCSV("src/test/resources/testDataForOrder.csv");
    }
}
