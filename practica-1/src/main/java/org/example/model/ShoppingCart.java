package org.example.model;

import java.util.*;

public class ShoppingCart {
    private List<ShoppingCartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        for (ShoppingCartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new ShoppingCartItem(product, quantity));
    }

    public void modifyItem(Product product, int newQuantity) {

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        for (ShoppingCartItem item : items) {
            boolean productExist = product.equals(item.getProduct());

            if (productExist) {
                if (newQuantity == 0) removeItem(product);
                else item.setQuantity(newQuantity);

                return;
            }
        }
    }

    public void removeItem(Product product) {

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        items.removeIf(item -> item.getProduct().getName().equals(product.getName()));
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(ShoppingCartItem::getSubTotal)
                .sum();
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }
}
