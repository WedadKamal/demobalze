package org.example.stepDefs;

import com.fawry.TicketsMall.angularAutomation.constants.GeneralConstants;
import com.fawry.TicketsMall.angularAutomation.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P03_HomePage;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

public class D05_checkoutOrderDef extends BaseTest {


    public String actualResults;
    P03_HomePage homePageObj = new P03_HomePage(driver);

    @And("user select placeOrder button")
    public void selectPlaceOrder()
    {
        homePageObj.clickOnPlaceOrder();
    }

    @And("user enter placeorder data")
    public void enterPlaceOrderData()
    {
        homePageObj.enterPlaceorderDate();
    }

    @And("user select purchase button")
    public void selectPurchaseButton()
    {
        homePageObj.clickOnPurchaseButton();
    }

    @Then("user could assert on thank you message")
    public void checkThankYouMsg()
    {
        actualResults= homePageObj.getThankYouText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResults,  GeneralConstants.THANKYOUMSG,
                GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert that THANK YOU MSG appears" );

        Assert.assertEquals( GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert that THANK YOU MSG appears",
                GeneralConstants.THANKYOUMSG ,actualResults);
        softAssert.assertAll();
    }
}
