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

    // Catalog of all items in store
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

        int currentItems;

        for (int i = 0; i < quantity; i++); {
            cartItems.add(item);
        }
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

        // Adding count of existing cart items to cart
        int currentQuantity = 0;
        for (Item item : cartItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                currentQuantity++;
            }
        }

        if (currentQuantity == 0) {
            Utils.print("That item was not found in your cart. Please try again");
        }

        // if quantity to remove >= currentQuantity remove item(s) from cart
        
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
        double subtotal = 0.0;

        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String name = entry.getKey();
            int quantity = entry.getValue();
            Item item = catalog.getItemByName(name);
            double price = item.getPrice();
            double productsTotal = price * quantity;
            subtotal += productsTotal;

            System.out.printf("%-20s $%5.2f x%-3d = %6.2f%n", name, price, quantity, productsTotal);
        }
    System.out.printf("\nSubtotal:%31.2f%n", subtotal);
    }

    // need checkout method to be able to test
    @Override
    public void checkout() {
        if (cartItems.isEmpty()) {
            Utils.print("The cart is empty");
            return;
        }
        double subtotal = 0.0;

        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String name = entry.getKey();
            int quantity = entry.getValue();
            Item item = catalog.getItemByName(name);
            double price = item.getPrice();
            double productsTotal = price * quantity;
            subtotal += productsTotal;
        }

        double taxRate = 0.082;
        double salesTax = subtotal * taxRate;
        double total = subtotal + salesTax;

        System.out.printf("\nSubtotal:     $%6.2f%n", subtotal);
        System.out.printf("Sales Tax:     $%6.2f%n", salesTax);
        System.out.printf("Total:     $%6.2f%n", total);

        cartItems.clear();
        Utils.print("\nCheckout process complete.");
    }

    // helper method to test commands
    public int getCartQuantity(String name) {
        return cartItems.getOrDefault(name, 0);
    }
}
