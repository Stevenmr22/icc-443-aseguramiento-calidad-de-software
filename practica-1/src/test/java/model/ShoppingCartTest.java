package model;

import org.example.model.Product;
import org.example.model.ShoppingCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    /**
     * Test to verify adding a valid item to the shopping cart.
     */
    @Test
    @DisplayName("Test addItem valid item to cart")
    void testAddItemValid() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("bread", "Bread", 25.0);
        cart.addItem(product, 2);

        assertEquals(1, cart.getItems().size(), "Cart should have one item");
        assertEquals(50.0, cart.getTotal(), "Total should be 50.0");
    }

    /**
     * Test to ensure an exception is thrown when adding a null product to the cart.
     */
    @Test
    @DisplayName("Test addItem with null product")
    void testAddItemWithNullProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = null;

        try {
            cart.addItem(product, 2);
        } catch (IllegalArgumentException e) {
            assertEquals("Product cannot be null", e.getMessage(), "Should throw exception for null product");
        }
    }

    /**
     * Test to ensure an exception is thrown when adding an item with zero quantity to the cart.
     */
    @Test
    @DisplayName("Test addItem with zero quantity")
    void testAddItemWithZeroQuantity() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("bread", "Bread", 25.0);

        try {
            cart.addItem(product, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Quantity must be greater than zero", e.getMessage(), "Should throw exception for zero quantity");
        }
    }

    /**
     * Test to verify that adding an existing product updates its quantity in the cart.
     */
    @Test
    @DisplayName("Test addItem with existing product")
    void testAddItemExistingProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("bread", "Bread", 25.0);
        cart.addItem(product, 2);
        cart.addItem(product, 3);

        assertEquals(1, cart.getItems().size(), "Cart should still have one item");
        assertEquals(125.0, cart.getTotal(), "Total should be updated to 125.0");
    }

    /**
     * Test to verify removing a valid item from the shopping cart.
     */
    @Test
    @DisplayName("Test removeItem valid item from cart")
    void testRemoveItemValid() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("bread", "Bread", 25.0);
        cart.addItem(product, 2);
        cart.removeItem(product);

        assertEquals(0, cart.getItems().size(), "Cart should be empty after removing item");
        assertEquals(0.0, cart.getTotal(), "Total should be 0.0 after removing item");
    }

    /**
     * Test to ensure no exception is thrown when removing a non-existing product from the cart.
     */
    @Test
    @DisplayName("Test removeItem with non-existing product")
    void testRemoveItemNonExistingProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("bread", "Bread", 25.0);

        try {
            cart.removeItem(product);
        } catch (IllegalArgumentException e) {
            assertEquals("Product not found in cart", e.getMessage(), "Should throw exception for non-existing product");
        }
    }

    /**
     * Test to verify the total calculation with multiple items in the cart.
     */
    @Test
    @DisplayName("Test getTotal with multiple items")
    void testGetTotalWithMultipleItems() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("bread", "Bread", 25.0);
        Product product2 = new Product("milk", "Milk", 15.0);

        cart.addItem(product1, 2);
        cart.addItem(product2, 3);

        assertEquals(95.0, cart.getTotal(), "Total should be 95.0 with multiple items");
    }
}