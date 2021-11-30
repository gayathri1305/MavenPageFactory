package org.thoughtworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import resources.ScreenShot;

import java.io.IOException;

public class AddressPage {
        @FindBy(id = "order_bill_address_attributes_firstname")
        private WebElement firstNameTextBox;

        @FindBy(id = "order_bill_address_attributes_lastname")
        private  WebElement lastNameTextBox;

        @FindBy(id ="order_bill_address_attributes_address1")
        private WebElement address1TextBox;

        @FindBy(id = "order_bill_address_attributes_address2")
        private WebElement address2TextBox;

        @FindBy(id ="order_bill_address_attributes_city")
        private WebElement cityTextBox;

        @FindBy(name = "order[bill_address_attributes][state_id]")
        private WebElement stateDropDown;

        @FindBy(name = "order[bill_address_attributes][zipcode]")
        private WebElement zipCodeTextBox;

        @FindBy(name = "order[bill_address_attributes][country_id]")
        private WebElement countryDropDown;

        @FindBy(id = "order_bill_address_attributes_phone")
        private WebElement phoneTextBox;

        @FindBy(css = "input[value='Save and Continue']")
        private  WebElement saveAndContinueButton;

        @FindBy(name= "order[use_billing]")
        private WebElement shippingSameBillingCheckBox;

        @FindBy(id = "save_user_address")
        private WebElement saveUserAddCheckBox;


        public AddressPage(WebDriver driver){
           // PageFactory.initElements(driver,this);
            PageFactory.initElements(new AjaxElementLocatorFactory(driver,2000),this);
        }
        public void enterBillingAddress(String fName,String lName,String address1,String city,String state,String zipcode,String country,String phone){

            firstNameTextBox.sendKeys(fName);
            lastNameTextBox.sendKeys(lName);
            address1TextBox.sendKeys(address1);
            cityTextBox.sendKeys(city);

            Select dropCountry = new Select(countryDropDown);
            dropCountry.selectByVisibleText(country);

            Select dropState= new Select(stateDropDown);
            dropState.selectByVisibleText(state);

            zipCodeTextBox.sendKeys(zipcode);
            phoneTextBox.sendKeys(phone);


        }
        public void shippingSameAsBilling(WebDriver driver) throws IOException {
            Assert.assertTrue(shippingSameBillingCheckBox.isSelected());
            saveUserAddCheckBox.click();
            new ScreenShot().takeScreenShotTime(driver,"addressPage");
            Assert.assertFalse(saveUserAddCheckBox.isSelected());
            saveAndContinueButton.click();

        }
}
