package org.example.pages;

import com.fawry.TicketsMall.angularAutomation.constants.GeneralConstants;
import com.fawry.TicketsMall.angularAutomation.pages.MainPage;
import com.fawry.TicketsMall.angularAutomation.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class P02_login extends MainPage {
    public P02_login(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[contains(text(),'Welcome')]")
    WebElement welcomeMsg;

    @FindBy(xpath="//a[contains(text(),'Log out')]")
    WebElement logOut;

    @FindBy(xpath="//button[contains(text(),'Log in')]")
    WebElement loginBtnInLogPage;

    @FindBy(xpath="//a[text()='Log in']")
    WebElement logInBtn;

    @FindBy(id="loginusername")
    WebElement loginUserName;

    @FindBy(id="loginpassword")
    WebElement loginPassword;
    public static String name;

    public void clickOnLoginBtn() {
        try {


            logInBtn.click();

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
    public String getLoginUserName() {
       String loginUser;
        try {


            loginUser=  loginUserName.getAttribute("value");

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

            return GeneralConstants.FAILED;
        }
        return loginUser;
    }

    public void enterUserNameAndPassword(String username,String password) {
        try {


            setTextValue(loginUserName,username);
            setTextValue(loginPassword,password);
            name = getLoginUserName();

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

    public void clickOnSignInOnLoginPage() {
        try {


            loginBtnInLogPage.click();

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

    public String getWelcomeText() {
        String welcomeText;
        try {


            welcomeText= welcomeMsg.getText();

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

            return GeneralConstants.FAILED;
        }
        return welcomeText;
    }

    public String getLogOutText() {
        String logOutText;
        try {


            logOutText= logOut.getText();

        } catch (Exception e) {
            Log.error("Error occurred in " + new Object() {
            }
                    .getClass().getName() + "." + new Object() {
            }
                    .getClass()
                    .getEnclosingMethod()
                    .getName(), e);

            return GeneralConstants.FAILED;
        }
        return logOutText;
    }



}
