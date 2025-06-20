package com.shoppinginc.services;
import com.shoppinginc.models.*;
import com.shoppinginc.interfaces.CartCommands;

import java.util.HashMap;
import java.util.Map;

public class CartService implements CartCommands {
    // fields
    // Catalog of all items in store
    private final Catalog catalog;

    // Cart map
    private final Map<String, Integer> cartItems;

    // Constructor
    public CartService(Catalog catalog) {
        this.catalog = catalog;
        this.cartItems = new HashMap<>();
    }

    // Add item method
    @Override
    public void addItem(Item item, int quantity) {
        String name = item.getName();

        int currentItems;

        if (cartItems.containsKey(name)) {
            currentItems = cartItems.get(name);
        } else {
            currentItems = 0;
        }
    }
    // helper method to test addItem
    public int getCartQuantity(String name) {
        return cartItems.getOrDefault(name, 0);
    }


}
