package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {

    @Test
    public void checkGoodsInCart() {
        System.out.println("CartTest inc is running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        // loginPage.open("cart.html");
        productsPage.switchToCart();
        cartPage.isPageLoaded("Your Cart");
        System.out.println(cartPage.getProductsNames() + "!!!!!!!!!!!!!!!!!!!!!!");
        assertEquals(cartPage.getProductsNames().size(), 2);
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Bolt T-Shirt"));
    }
}
