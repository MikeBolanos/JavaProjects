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

    // Remove item method
    @Override
    public void removeItem(String itemName, int quantity) {
        // Display cart to see if the cart is empty first
        displayCart();

        // If cart is empty, display message
        if(cartItems.isEmpty()) {
            Utils.print("This cart is empty.");
            return;
        }

        //  Check if item is in the cart
        if (!cartItems.containsKey(itemName)) { // If item is not in cart, display error message
            Utils.print("That item was not found in your cart. Please try again");
            return;
        }

        // current quantity
        int currentQuantity = cartItems.get(itemName);

        // if quantity to remove >= currentQuantity remove item(s) from cart
        if (quantity >= currentQuantity) {
            cartItems.remove(itemName);
            Utils.print("Removed all " + itemName + " items from the cart");
            // Else subtract quantity with confirmation message
        } else {
            cartItems.put(itemName, currentQuantity - quantity);
            Utils.print("Removed " + quantity + " of " + itemName + " items from the cart");
        }
    }

    // Display Cart Method
    @Override
    public void displayCart() {
        if (cartItems.isEmpty()) {
            Utils.print("The cart is empty");
            return;
        }
    }

    // need checkout method to be able to test
    @Override
    public void checkout() {
        Utils.print("");
    }

    // helper method to test commands
    public int getCartQuantity(String name) {
        return cartItems.getOrDefault(name, 0);
    }
}
