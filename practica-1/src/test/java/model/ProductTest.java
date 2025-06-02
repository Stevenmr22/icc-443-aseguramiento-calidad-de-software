package model;

import org.example.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {

    /**
     * Test to verify the correct creation of a Product object.
     */
    @Test
    @DisplayName("Test Product Creation")
    void testProductCreation (){
        Product product = new Product("bread", "Bread", 25.0);

        assertEquals("bread", product.getId(), "Product ID should be 'bread'");
        assertEquals("Bread", product.getName(), "Product name should be 'Bread'");
        assertEquals(25.0, product.getPrice(), "Product price should be 25.0");
    }

    /**
     * Test to ensure an exception is thrown when creating a Product with a null ID.
     */
    @Test
    @DisplayName("Test Product Creation with Null ID")
    public void testCreateProductWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product(null, "Bread", 25.0);
        }, "Product ID cannot be null or empty");
    }

    /**
     * Test to ensure an exception is thrown when creating a Product with a null name.
     */
    @Test
    @DisplayName("Test Product Creation with Null Name")
    public void  testCreateProductWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("bread", null, 25.0);
        }, "Product name cannot be null or empty");
    }

    /**
     * Test to ensure an exception is thrown when creating a Product with a negative price.
     */
    @Test
    @DisplayName("Test Product Creation with Negative Price")
    public void testCreateProductWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("Bread", "Bread",-10.0);
        }, "Product price cannot be negative");
    }

    /**
     * Test to verify that the price of a Product can be updated correctly.
     */
    @Test
    void testProductPriceUpdate() {
        Product product = new Product("bread", "Bread", 25.0);
        product.setPrice(30.0);
        assertEquals(30.0, product.getPrice());
    }
}