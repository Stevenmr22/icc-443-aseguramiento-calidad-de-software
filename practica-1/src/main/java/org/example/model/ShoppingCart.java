package org.example.model;

import java.util.*;

public class ShoppingCart {
    private List<ShoppingCartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        for (ShoppingCartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new ShoppingCartItem(product, quantity));
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().getName().equals(product.getName()));
    }

    public void modifyItem(Product product, int quantity){
        for (ShoppingCartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                if (quantity <= 0) {
                    items.remove(item);
                } else {
                    item.setQuantity(quantity);
                }
                return;
            }
        }
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
