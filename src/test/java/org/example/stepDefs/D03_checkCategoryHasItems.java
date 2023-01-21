package org.example.stepDefs;

import com.fawry.TicketsMall.angularAutomation.constants.GeneralConstants;
import com.fawry.TicketsMall.angularAutomation.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_HomePage;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

public class D03_checkCategoryHasItems extends BaseTest {

    public String actualResults;
    P03_HomePage homePageObj = new P03_HomePage(driver);

    @When("get categories text")
    public void getCategoriesText()
    {

       actualResults= homePageObj.getCategoriesText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResults,  GeneralConstants.CATEGORIES,
                GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in categories text" );

        Assert.assertEquals( GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in categories text",
                GeneralConstants.CATEGORIES ,actualResults);


        softAssert.assertAll();

    }


    @Then("Assert categories have Items")
    public void checkCategoriesHaveItems()
    {

       actualResults= homePageObj.checkCategoryHasItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResults,  GeneralConstants.SUCCESS,
                GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in categories list has Items" );

        Assert.assertEquals( GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in categories list has Items",
                GeneralConstants.SUCCESS ,actualResults);

        softAssert.assertTrue(P03_HomePage.categoriesSize>0,
                GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in categories list size bigger than 0" );

        Assert.assertTrue( GeneralConstants.POM_EXCEPTION_ERR_MSG + "While assert in categories list size bigger than 0",
                P03_HomePage.categoriesSize>0);
        softAssert.assertAll();


    }
}
