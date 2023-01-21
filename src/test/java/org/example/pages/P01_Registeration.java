package org.example.pages;

import com.fawry.TicketsMall.angularAutomation.pages.MainPage;
import com.fawry.TicketsMall.angularAutomation.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P01_Registeration extends MainPage {
    public P01_Registeration(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[text()='Sign up']")
    WebElement signUpBtn;

    @FindBy(xpath="//div[@class='modal-footer']//button[text()='Sign up']")
    WebElement signUpBtnInRegPage;





    public void clickOnRegisterBtn() {
        try {


            signUpBtn.click();

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

        }
    }
    public void enterUserNameAndPassword(String username,String password) {
        try {

            setTextValue(userName,username);
            setTextValue(passWord,password);

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

        }
    }

    public void clickOnSignUpOnRegisterationPage() {
        try {


            scrollIntoViewAndClick(signUpBtnInRegPage);
            Thread.sleep(2000);

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

        }
    }


}
