package model;

import org.example.model.Product;
import org.example.model.ShoppingCartItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShoppingCartItemTest {

    /**
     * Test to verify the correct creation of a ShoppingCartItem object.
     */
    @Test
    @DisplayName("Test ShoppingCartItem Creation")
    void testShoppingCartItemCreation() {
        Product product = new Product("bread", "Bread", 25.0);
        ShoppingCartItem item = new ShoppingCartItem(product, 2);

        assertEquals(product, item.getProduct(), "Product should match");
        assertEquals(2, item.getQuantity(), "Quantity should be 2");
        assertEquals(50.0, item.getSubTotal(), "Subtotal should be 50.0");
    }

    /**
     * Test to ensure an exception is thrown when creating a ShoppingCartItem with a null product.
     */
    @Test
    @DisplayName("Test ShoppingCartItem creation with product null")
    void testShoppingCartItemCreationWithNullProduct() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ShoppingCartItem(null, 2);
        }, "Product cannot be null");
    }

    /**
     * Test to ensure an exception is thrown when creating a ShoppingCartItem with a negative quantity.
     */
    @Test
    @DisplayName("Test ShoppingCartItem creation with negative quantity")
    void testShoppingCartItemCreationWithNegativeQuantity() {
        Product product = new Product("bread", "Bread", 25.0);
        assertThrows(IllegalArgumentException.class, () -> {
            new ShoppingCartItem(product, -1);
        }, "Quantity must be greater than zero");
    }

    /**
     * Test to ensure an exception is thrown when creating a ShoppingCartItem with zero quantity.
     */
    @Test
    @DisplayName("Test ShoppingCartItem creation with zero quantity")
    void testShoppingCartItemCreationWithZeroQuantity() {
        Product product = new Product("bread", "Bread", 25.0);
        assertThrows(IllegalArgumentException.class, () -> {
            new ShoppingCartItem(product, 0);
        }, "Quantity must be greater than zero");
    }

    /**
     * Test to verify that the quantity of a ShoppingCartItem can be updated correctly.
     */
    @Test
    @DisplayName("Test ShoppingCartItem quantity update")
    void testShoppingCartItemQuantityUpdate() {
        Product product = new Product("bread", "Bread", 25.0);
        ShoppingCartItem item = new ShoppingCartItem(product, 2);

        item.setQuantity(3);
        assertEquals(3, item.getQuantity(), "Quantity should be updated to 3");
        assertEquals(75.0, item.getSubTotal(), "Subtotal should be updated to 75.0");
    }
}