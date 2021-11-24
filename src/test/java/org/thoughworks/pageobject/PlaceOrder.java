package org.thoughworks.pageobject;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.thoughworks.pageobject.pages.*;
import resources.ScreenShot;


import java.io.IOException;


public class PlaceOrder extends BaseTest {


    @Test
    public void placingOrder() throws IOException {
            test = extent.startTest("placingOrder");

            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            CategoryPage categoryPage = new CategoryPage(driver);
            ProductPage productPage = new ProductPage(driver);
            CartPage cartPage = new CartPage(driver);
            AddressPage addressPage = new AddressPage(driver);
            ShippingMethodPage shippingMethodPage = new ShippingMethodPage(driver);
            PaymentPage paymentPage = new PaymentPage(driver);
            OrderCompletionPage orderCompletionPage = new OrderCompletionPage(driver);

            loginPage.login("test12@test.in", "123456");
            String loginSuccessMessage = homePage.verifyLoginSuccess();
            Assert.assertEquals(loginSuccessMessage, "Logged in successfully");
            categoryPage.selectProduct();
            productPage.addProductToCart(2);
            String totalText = cartPage.getCartTotal();
            cartPage.cartCheckout(driver);
            Assert.assertEquals(totalText, "$31.98");
            addressPage.enterBillingAddress("gayathri","S","Jp Nagar","xyzxyz","District of Columbia","20002","United States of America","6754632173");
            addressPage.shippingSameAsBilling(driver);
            shippingMethodPage.selectShippingMethod();
            paymentPage.selectCheckPay();
            String orderSuccessMessage=orderCompletionPage.getOrderStatus();
            Assert.assertEquals(orderSuccessMessage,"Your order has been processed successfully");

    }


}
