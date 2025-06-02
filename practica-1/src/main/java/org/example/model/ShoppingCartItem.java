package org.example.model;

public class ShoppingCartItem {
    private Product product;
    private int quantity;

    public ShoppingCartItem(Product product, int quantity) {

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        this.quantity = quantity;
    }

    public double getSubTotal() {
        return product.getPrice() * quantity;
    }
}
