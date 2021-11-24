package org.thoughworks.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
    @FindBy(linkText = "Bags")
    private WebElement bagsCategory;

    @FindBy(css = "span[title='Ruby on Rails Tote']")
    private WebElement bagsProduct;


    public CategoryPage(WebDriver driver){
       // PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,2000),this);
    }

    public  void selectProduct(){
        bagsCategory.click();

        bagsProduct.click();
    }
}
