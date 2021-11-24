package org.thoughworks.pageobject.pages;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resources.ScreenShot;

import java.io.File;
import java.io.IOException;


public class CartPage {
    @FindBy(css = "tr.table-warning.cart-total td.lead")
    private WebElement totalText;
    @FindBy(css = "button[name='checkout']")
    private WebElement checkoutButton;


    public CartPage(WebDriver driver){
        System.out.println("I m inside the constructor of cart page");
       // PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,2000),this);


    }
    public  String getCartTotal(){
        return totalText.getText();
    }
    public void cartCheckout(WebDriver driver) throws IOException {

        //Take screenshot
        new ScreenShot().takeScreenShotTime(driver,"CartPage");
        checkoutButton.click();
    }
}
