package org.thoughtworks;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.thoughtworks.pages.*;
import resources.BaseTest;


import java.io.IOException;


public class AddToCartTest extends BaseTest {


    @Test
    public void selectFirstCategory() throws IOException {

            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            CategoryPage categoryPage = new CategoryPage(driver);

            loginPage.login("test12@test.in", "123456");
            String loginSuccessMessage = homePage.verifyLoginSuccess();
            Assert.assertEquals(loginSuccessMessage, "Logged in successfully");
            categoryPage.selectProduct();


    }
        @Test
        public void checkloginSuccess() throws IOException {


                LoginPage loginPage = new LoginPage(driver);
                HomePage homePage = new HomePage(driver);

                loginPage.login("test12@test.in", "123456");
                String loginSuccessMessage = homePage.verifyLoginSuccess();
                Assert.assertEquals(loginSuccessMessage, "Logged in successfully");


        }



}
