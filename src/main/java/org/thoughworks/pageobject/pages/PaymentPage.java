package org.thoughworks.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaymentPage {

    @FindBy(css = "li.list-group-item.radio:nth-child(2) input")
    private WebElement checkRadio;

    @FindBy(css ="input[value='Save and Continue']")
    private WebElement saveAndConButton;

    public  PaymentPage(WebDriver driver){
        //PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,2000),this);
    }

    public void selectCheckPay(){
        checkRadio.click();
        saveAndConButton.click();
    }

}
