import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart(6);
        assertEquals(productsPage.checkGoodsQuantity(), "1");
        //      assertEquals(productsPage.checkGoodsQuantitytttt(), "dsfsdfsd2");
    }

    public static class LoginTest extends BaseTest {

        @DataProvider(name = "invalidData")
        public Object[][] loginData() {
            return new Object[][]{
                    {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                    {"", "secret_sauce", "Epic sadface: Username is required"},
                    {"standard_user", "", "Epic sadface: Password is required"},
                    {"Locked_out_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
            };
        }

        @Test(description = "Проверка корректного логина", priority = 1, dataProvider = "invalidData")
        public void checkIncorrectLogin(String user, String password, String errorMsg) {
            loginPage.open();
            loginPage.login(user, password);
            assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
            assertEquals(loginPage.errorMessageText(), errorMsg);
        }

        @Test(priority = 2, enabled = true, invocationCount = 1, alwaysRun = true)
        public void checkCorrectLogin() {
            loginPage.open();
            loginPage.login("standard_user", "secret_sauce");

            assertTrue(productsPage.isPageLoaded("Products"), "Register btn is not visible");
        }
    }
}