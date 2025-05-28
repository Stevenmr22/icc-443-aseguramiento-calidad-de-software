package model;

import org.example.model.Product;
import org.example.model.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {
    @Test
    void testAddItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Product("Cheese", 80.0), 1);
        assertEquals(1, shoppingCart.getItems().size());
    }

    @Test
    void testRemoveItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("Cheese", 80.0);
        shoppingCart.addItem(product, 1);
        shoppingCart.removeItem(product);
        assertEquals(0, shoppingCart.getItems().size());
    }

    @Test
    void testModifyItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("Cheese", 80.0);
        shoppingCart.addItem(product, 1);
        shoppingCart.modifyItem(product, 2);
        assertEquals(2, shoppingCart.getItems().getFirst().getQuantity());
    }

    @Test
    void testGetTotal() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Product("Cheese", 80.0), 1);
        shoppingCart.addItem(new Product("Bread", 25.0), 2);
        assertEquals(130.0, shoppingCart.getTotal());
    }

}
