package org.example.stepDefs;

import com.fawry.TicketsMall.angularAutomation.constants.GeneralConstants;
import com.fawry.TicketsMall.angularAutomation.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

public class D04_addRandomItemToCartAndRemoveItDef extends BaseTest {


    public String actualResults;
    P03_HomePage homePageObj = new P03_HomePage(driver);

    @When("user select random Item")
    public void selectRandomItem()
    {

       homePageObj.selectRandomItem();

    }

    @And("user remove the item from the cart")
    public void clickOnDeleteItem()
    {

       homePageObj.clickOnDeleteItem();

    }

    @Then("user could assert that item doesn`t display on the cart")
    public void checkItemNotDisplayOnCart() throws InterruptedException {

      actualResults= homePageObj.
              checkItemNameNotDisplay();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResults,  GeneralConstants.SUCCESS,
                GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert that item Name not display On Cart" );

        Assert.assertEquals( GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert that item Name not display On Cart",
                GeneralConstants.SUCCESS ,actualResults);
        softAssert.assertAll();

    }

    @And("user click on add cart Button")
    public void clickOnAddCartButton()
    {

        actualResults = homePageObj.getItemText();
        homePageObj.selectAddCartBtn();


    }

    @And("user select cart page")
    public void selectCartPage()
    {
        homePageObj.selectCart();


    }

    @Then("user could assert that item displayed on the cart")
    public void checkItemDisplayedOnCart()
    {

         homePageObj.selectCart();
       String actulResult2= homePageObj.getItemNameFromCart();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actulResult2,  actualResults,
                GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in item Name On Cart" );

        Assert.assertEquals( GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in item Name On Cart",
               actulResult2 ,actualResults);


        softAssert.assertAll();


    }
}
