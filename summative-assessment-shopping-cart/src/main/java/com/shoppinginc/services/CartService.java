package com.shoppinginc.services;
import com.shoppinginc.models.*;
import com.shoppinginc.interfaces.CartCommands;
import com.shoppinginc.utils.Utils;

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

        currentItems = cartItems.getOrDefault(name, 0);
        cartItems.put(name, currentItems + quantity);
    }

    // helper method to test addItem
    public int getCartQuantity(String name) {
        return cartItems.getOrDefault(name, 0);
    }

    // Remove item method
    @Override
    public void removeItem(String itemName, int quantity) {
        // Display cart to see if the cart is empty first
        displayCart();

        // If cart is empty, display message
        if(!cartItems.isEmpty()) {
            Utils.print("This cart is empty.");
        } return;

    }

    // need checkout method to be able to test
    @Override
    public void displayCart() {

    }

    // need checkout method to be able to test
    @Override
    public void checkout() {
        Utils.print("");
    }

}
