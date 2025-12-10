import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
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
