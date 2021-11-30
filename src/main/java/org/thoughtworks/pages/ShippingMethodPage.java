package org.thoughtworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ShippingMethodPage {

    @FindBy(name ="order[shipments_attributes][0][selected_shipping_rate_id]")
    private WebElement upsGroundRadio;

    @FindBy(css = "input[value='Save and Continue']")
    private WebElement saveAndContinueButton;


    public ShippingMethodPage(WebDriver driver){
       // PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,2000),this);
    }

    public void selectShippingMethod(){

        upsGroundRadio.click();
        saveAndContinueButton.click();

    }



}
