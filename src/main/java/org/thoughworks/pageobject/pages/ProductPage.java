package org.thoughworks.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProductPage {
    @FindBy(id = "quantity")
    private WebElement quantityTextBox;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;


    public ProductPage(WebDriver driver){
        //PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,2000),this);
    }

    public void addProductToCart(int quantity){
        quantityTextBox.clear();
        quantityTextBox.sendKeys(Integer.toString(quantity));
        addToCartButton.click();
    }
}
