package model;

import org.example.model.Product;
import org.example.model.ShoppingCartItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartItemTest {

    @Test
    void testSubTotal() {
        Product product = new Product("Milk", 50.0);
        ShoppingCartItem item = new ShoppingCartItem(product, 2);
        assertEquals(100.0, item.getSubTotal());
    }
}
