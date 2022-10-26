package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;
import pages.PlaceOrderPage;

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
}
