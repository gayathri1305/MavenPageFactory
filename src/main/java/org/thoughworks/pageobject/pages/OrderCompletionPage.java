package org.thoughworks.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderCompletionPage {
    @FindBy(css = ".alert.alert-notice")
    private WebElement orderSuccessMessage;


    public OrderCompletionPage(WebDriver driver){
        //PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,2000),this);
    }

    public  String getOrderStatus(){
        return orderSuccessMessage.getText();

    }
}
