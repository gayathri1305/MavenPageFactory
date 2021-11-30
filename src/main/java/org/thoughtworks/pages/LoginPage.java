package org.thoughtworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class LoginPage {
    @FindBy(linkText = "Login")
    private WebElement login;

    @FindBy(name = "spree_user[email]")
    private WebElement emailTextBox;  //String str = "Name";
    //driver.findElement(BY.id("")) - WebElement

    @FindBy(id = "spree_user_password")
    private  WebElement passwordTextBox;

    @FindBy(css = "input[value='Login']")
    private WebElement loginButton;

    //WebDriverWait wait;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,2000),this);
        //PageFactory.initElements(driver,this);
        //wait = new WebDriverWait(driver,50000);
    }

    public void login(String email, String password){
        //wait.until(ExpectedConditions.visibilityOf(login));
        login.click();
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();
    }
}
