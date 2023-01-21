package org.example.pages;

import com.fawry.TicketsMall.angularAutomation.constants.GeneralConstants;
import com.fawry.TicketsMall.angularAutomation.pages.MainPage;
import com.fawry.TicketsMall.angularAutomation.utils.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class P03_HomePage extends MainPage {
    public P03_HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="itemc")
    List<WebElement> categoryItem;

    @FindBy(xpath="//div[@class='col-lg-4 col-md-6 mb-4']")
    List<WebElement> pageItems;

    @FindBy(xpath="//a[text()='CATEGORIES']")
    WebElement categories;

    @FindBy(xpath="//a[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath="//button[text()='Place Order']")
    WebElement placeOrderBtn;

    @FindBy(xpath="//a[text()='Cart']")
    WebElement cartView;

    @FindBy(id="name")
    WebElement placeOrderName;

    @FindBy(id="country")
    WebElement placeOrderCountry;

    @FindBy(id="city")
    WebElement placeOrderCity;

    @FindBy(id="card")
    WebElement placeOrderCard;

    @FindBy(id="month")
    WebElement placeOrderMonth;

    @FindBy(id="year")
    WebElement placeOrderYear;

    @FindBy(xpath="//button[text()='Purchase']")
    WebElement purchaseBtn;

    @FindBy(xpath="//h2[@class='name']")
    WebElement itemName;

    @FindBy(xpath="//h2[text()='Thank you for your purchase!']")
    WebElement thankMsgForPurchase;

    @FindBy(xpath="//button[text()='OK']")
    WebElement okBtn;

    @FindBy(xpath="//a[text()='Delete']")
    WebElement deleteBtn;

    @FindBy(xpath="//tr//td[2]")
    List<WebElement> itemNameOnCart;

    public static int categoriesSize;

    public String getCategoriesText() {
        String categoriesText;
        try {
            scrollIntoView(categories);
            categoriesText=  categories.getText();

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
        return categoriesText;
    }
    public String getItemText() {
        String itemText;
        try {
            scrollIntoView(itemName);
            itemText=  itemName.getText();

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
        return itemText;
    }
    public String getThankYouText() {
        String msgText;
        try {
            scrollIntoView(thankMsgForPurchase);
            msgText=  thankMsgForPurchase.getText();

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
        return msgText;
    }
    public void selectRandomItem() {

        try {
            Thread.sleep(6000);
            int count = pageItems.size();
            System.out.println("count is "+count);
            int min = 0;
            int max = count-1;
            int selectedItem = (int)Math.floor(Math.random()*(max-min+1)+min);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(pageItems.get(selectedItem)));
            scrollIntoView(pageItems.get(selectedItem));
            pageItems.get(selectedItem).click();
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
    public void selectCart() {

        try {

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
           scrollIntoViewAndClick(cartView);


        } catch (Exception e) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                ((Alert) alert).accept();
            } catch (NoAlertPresentException ee) {
                e.printStackTrace();
            }


        }

    }
    public void clickOnDeleteItem() {

        try {

            deleteBtn.click();

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
    public void clickOnPlaceOrder() {

        try {

            placeOrderBtn.click();

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
    public void clickOnPurchaseButton() {

        try {

            purchaseBtn.click();

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
    public void enterPlaceorderDate() {

        try {

            setTextValue(placeOrderName,"wedad");
            setTextValue(placeOrderCountry,"Egypt");
            setTextValue(placeOrderCity,"cairo");
            setTextValue(placeOrderCard,"1234567891234569");
            setTextValue(placeOrderMonth,"5");
            setTextValue(placeOrderYear,"2022");

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
    public String checkItemNameNotDisplay() throws InterruptedException {


        Thread.sleep(4000);
      String actual = GeneralConstants.FAILED;
        try {
            if (itemNameOnCart.size()==0) {
                actual = GeneralConstants.SUCCESS;
                return actual;
            }else
            {
                return actual;
            }

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
    }
    public String getItemNameFromCart() {

        String itemName;
        try {

            itemName=  itemNameOnCart.get(0).getText();

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

        return itemName;
    }
    public void selectAddCartBtn() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
            scrollIntoView(addToCartBtn);
            addToCartBtn.click();
            Thread.sleep(2000);
         //  driver.navigate().refresh();

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

    public String checkCategoryHasItems() {
        String actulResult= GeneralConstants.FAILED;
        try {

            categoriesSize = categoryItem.size();
            if (categoryItem.size()>0){
                actulResult= GeneralConstants.SUCCESS;

            }
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
        return actulResult;
    }


}
