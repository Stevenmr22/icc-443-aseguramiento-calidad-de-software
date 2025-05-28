package model;

import org.example.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void testProductCreation (){
        Product product = new Product("Bread", 25.0);
        assertEquals("Bread", product.getName());
        assertEquals(25.0, product.getPrice());
    }

    @Test
    void testProductPriceUpdate() {
        Product product = new Product("Bread", 25.0);
        product.setPrice(30.0);
        assertEquals(30.0, product.getPrice());
    }
}
