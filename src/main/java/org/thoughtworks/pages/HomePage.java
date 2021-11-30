package org.thoughtworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class HomePage {
    @FindBy(css = ".alert.alert-success")
    private WebElement loginSuccessMessage;


    public  HomePage(WebDriver driver){
       // PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,2000),this);

    }

    public String verifyLoginSuccess(){
        return loginSuccessMessage.getText();

    }
}
