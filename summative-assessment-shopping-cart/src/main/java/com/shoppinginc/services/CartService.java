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

    @Override
    public boolean isCartEmpty() {
        return cartItems.isEmpty();
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
        Utils.print(quantity + " " + item.getName() + " items added to your Cart");
    }

    // Remove item method
    @Override
    public void removeItem(String itemName, int quantity) {
        if (isCartEmpty()) {
            Utils.print("The cart is empty");
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
    public void displayCartWithSubtotal() {
        if (isCartEmpty()) {
            Utils.print("The cart is empty");
            return;
        }

        Map<Item, Integer> subtotal = getCartSubtotal();

        double subtotal = 0.0;

        Utils.print("~*~*~*~Shopping Cart~*~*~*~");

        for(String name : itemCounts.keySet()) {
            int quantity = itemCounts.get(name);
            Item item = mapItem.get(name);
            double price = item.getPrice();
            double result = quantity * price;

        System.out.printf("%-20s $%5.2f x%-3d= $%6.2f%n", name, price, quantity, result);
        subtotal += result;
        }
        System.out.printf("\nSubtotal:%32s%n", String.format("$%6.2f", subtotal));
    }


    @Override
    public void checkout() {

        if (isCartEmpty()) {
            Utils.print("The cart is empty");
            return;
        }
        double subtotal = displayCartWithSubtotal();
        double taxRate = 0.082;
        double salesTax = subtotal * taxRate;
        double total = subtotal + salesTax;

        System.out.printf("Sales Tax (8.2%%): %23s%n", String.format("$%6.2f", salesTax));
        System.out.printf("Total:%35s%n", String.format("$%6.2f", total));

        cartItems.clear();
        Utils.print("\nCheckout process complete.");
    }

    public Map<Item, Integer> getCartSubtotal() {
        Map<Item, Integer> subtotal = new HashMap<>();
        for (Item item : cartItems) {
            subtotal.put(item, subtotal.getOrDefault(item, 0)+1);
        }
        return subtotal;
    }

    // getter for CartItems for use in tests
    public List<Item> getCartItems() {
        return cartItems;
    }

}
