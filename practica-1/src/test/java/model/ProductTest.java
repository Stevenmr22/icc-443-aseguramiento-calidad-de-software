package model;

import org.example.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    /**
     * Verifica que un producto se cree correctamente con el nombre y precio especificados.
     */
    @Test
    void testProductCreation (){
        Product product = new Product("Bread", 25.0);
        assertEquals("Bread", product.getName());
        assertEquals(25.0, product.getPrice());
    }

    /**
     * Verifica que el precio de un producto se pueda actualizar correctamente.
     */
    @Test
    void testProductPriceUpdate() {
        Product product = new Product("Bread", 25.0);
        product.setPrice(30.0);
        assertEquals(30.0, product.getPrice());
    }
}