package model;

import org.example.model.Product;
import org.example.model.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    /**
     * Verifica que un producto se pueda agregar correctamente al carrito.
     */
    @Test
    void testAddItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Product("Cheese", 80.0), 1);
        assertEquals(1, shoppingCart.getItems().size());
    }

    /**
     * Verifica que un producto se pueda eliminar correctamente del carrito.
     */
    @Test
    void testRemoveItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("Cheese", 80.0);
        shoppingCart.addItem(product, 1);
        shoppingCart.removeItem(product);
        assertEquals(0, shoppingCart.getItems().size());
    }

    /**
     * Verifica que la cantidad de un producto en el carrito se pueda modificar correctamente.
     */
    @Test
    void testModifyItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("Cheese", 80.0);
        shoppingCart.addItem(product, 1);
        shoppingCart.modifyItem(product, 2);
        assertEquals(2, shoppingCart.getItems().getFirst().getQuantity());
    }

    /**
     * Verifica que el total del carrito se calcule correctamente sumando los subtotales
     * de todos los productos en el carrito.
     */
    @Test
    void testGetTotal() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Product("Cheese", 80.0), 1);
        shoppingCart.addItem(new Product("Bread", 25.0), 2);
        assertEquals(130.0, shoppingCart.getTotal());
    }
}