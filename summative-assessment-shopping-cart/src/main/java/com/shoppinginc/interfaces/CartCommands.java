package com.shoppinginc.interfaces;

import com.shoppinginc.models.Item;


public interface CartCommands {
    // Add item method (Item, quantity)
    void addItem (Item item, int quantity);

    // Remove Item method (Item name, quantity)
    void removeItem(String itemName, int quantity);

    // Display cart method
    void displayCart();

    // Checkout method
    void checkout();
}
