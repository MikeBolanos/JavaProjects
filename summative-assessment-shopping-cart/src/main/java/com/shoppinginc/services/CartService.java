package com.shoppinginc.services;
import com.shoppinginc.models.*;
import com.shoppinginc.interfaces.CartCommands;
import com.shoppinginc.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CartService implements CartCommands {
    // fields

    private final Catalog catalog;
    private final List<Item> cartItems;


    // Constructor
    public CartService(Catalog catalog) {
        this.catalog = catalog;
        this.cartItems = new ArrayList<>();
    }

    // Add item method
    @Override
    public void addItem(Item item, int quantity) {
        String name = item.getName();

        if (quantity <= 0) {
            Utils.print("Cannot add zero or negative quantities. Please try again.");
            return;
        }

        for (int i = 0; i < quantity; i++) {
            cartItems.add(item);
        }
    }

    // Remove item method
    @Override
    public void removeItem(String itemName, int quantity) {
        // Display cart to see if the cart is empty first
        double subtotal = displayCartWithSubtotal();
        if (subtotal == 0.0) {
            return;
        }

        // Count of item quantities in current cart
        int currentQuantity = 0;
        for (Item item : cartItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                currentQuantity++;
            }
        }

        if (currentQuantity == 0) {
            Utils.print("That item was not found in your cart. Please try again");
            return;
        }

        int removedCount = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            Item item = cartItems.get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                cartItems.remove(i);
                i--;
                removedCount++;

                if (removedCount == quantity) {
                    break;
                }
            }
        }
        if (removedCount == currentQuantity) {
            Utils.print("Removed all " + itemName + " items from the cart.");
        } else {
            Utils.print("Removed " + removedCount + " " + itemName + " items from the cart");
        }
    }

    // Display Cart Method
    @Override
    public void displayCart() {
        displayCartWithSubtotal();
    }

    public double displayCartWithSubtotal() {
        if (cartItems.isEmpty()) {
            Utils.print("The cart is empty");
            return 0.0;
        }

        Map<String, Item> mapItem = new HashMap<>(); // item from HashMap
        Map<String, Integer> itemCounts = new HashMap<>(); // item counts

        for (Item item : cartItems) {
            String name = item.getName();

            if (catalog.getItemByName(name) == null) {
                continue;
            }
            // Count quantity of items
            itemCounts.put(name, itemCounts.getOrDefault(name, 0) + 1);

            if (!mapItem.containsKey(name)) {
                mapItem.put(name, item);
            }
        }

        double subtotal = 0.0;

        Utils.print("~*~*~*~Shopping Cart~*~*~*~");

        for(String name : itemCounts.keySet()) {
            int quantity = itemCounts.get(name);
            Item item = mapItem.get(name);
            double price = item.getPrice();
            double result = quantity * price;

        System.out.printf("%-20s $%5.2f x%-3d = $%6.2f%n", name, price, quantity, result);
        subtotal += result;
        }
        System.out.printf("\nSubtotal:$%32.2f%n", subtotal);
        return subtotal;
    }



    @Override
    public void checkout() {

        double subtotal = displayCartWithSubtotal();
        if (subtotal == 0.0) {
            return;
        }
        double taxRate = 0.082;
        double salesTax = subtotal * taxRate;
        double total = subtotal + salesTax;

        System.out.printf(" Sales Tax (8.2%%): $%20.2f%n", salesTax);
        System.out.printf("Total: $%20.2f%n", total);

        cartItems.clear();
        Utils.print("\nCheckout process complete.");
    }

    // getter for CartItems for use in tests
    public List<Item> getCartItems() {
        return cartItems;
    }

}
