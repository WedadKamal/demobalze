package org.example.stepDefs;

import com.fawry.TicketsMall.angularAutomation.constants.GeneralConstants;
import com.fawry.TicketsMall.angularAutomation.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;


public class D02_loginStepDef extends BaseTest {

    public String actualResults;
    P02_login loginPageObj = new P02_login(driver);

    @When("Click On login Button")
    public void clickingOnLoginBtn()
    {

        loginPageObj.clickOnLoginBtn();

    }

    @And("^enter \"(.*)\" and \"(.*)\"$")
    public void enterUserNameAndPassword(String userName, String password)
    {

        loginPageObj.enterUserNameAndPassword(userName,password);

    }

    @And("click on Signin on Login Page")
    public void clickOnSignInOnLoginPage()
    {

        loginPageObj.clickOnSignInOnLoginPage();

    }
    @Then("Assert on welcome word and logout word")
    public void checkWelcomeAndLogoutExist()
    {
        actualResults=  loginPageObj.getWelcomeText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResults,GeneralConstants.WELCOME +" "+P02_login.name,
                GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in Welome Msg" );

        Assert.assertEquals( GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in Welome Msg",
                GeneralConstants.WELCOME +" "+P02_login.name ,actualResults);

        actualResults=  loginPageObj.getLogOutText();
        softAssert.assertEquals(actualResults,GeneralConstants.LOGOUT,
                GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in Log out Msg" );
        Assert.assertEquals( GeneralConstants.POM_EXCEPTION_ERR_MSG + " While assert in Log out Msg",
                GeneralConstants.LOGOUT,actualResults);

        softAssert.assertAll();

    }
}
