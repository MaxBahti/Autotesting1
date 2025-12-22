package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        System.out.println("ProdTest inc is running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart(1);
        assertEquals(productsPage.checkGoodsQuantity(), "3");
    }
}