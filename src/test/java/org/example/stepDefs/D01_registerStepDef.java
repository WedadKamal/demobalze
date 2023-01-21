package org.example.stepDefs;

import com.fawry.TicketsMall.angularAutomation.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.pages.P01_Registeration;
import org.example.pages.P02_login;

public class D01_registerStepDef extends BaseTest {

    public String actualResults;
    P01_Registeration P01_Registeration = new P01_Registeration(driver);


    @When("Click on register Button")
    public void clickingOnRegisterBtn()
    {

        P01_Registeration.clickOnRegisterBtn();

    }
    @And("^enter \"(.*)\" and \"(.*)\" in Registeration Page$")
    public void enterUserNameAndPassword(String userName, String password)
    {

        P01_Registeration.enterUserNameAndPassword(userName,password);

    }

    @And("click on SignUp on Registeration Page")
    public void clickOnSignUpOnRegisterationPage()
    {

        P01_Registeration.clickOnSignUpOnRegisterationPage();

    }
}
