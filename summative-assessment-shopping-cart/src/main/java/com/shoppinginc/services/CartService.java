package com.shoppinginc.services;
import com.shoppinginc.models.*;
import com.shoppinginc.utils.Utils;
import com.shoppinginc.models.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CartService {

    private final List<Item> cartItems;

    public CartService() {
        this.cartItems = new ArrayList<>();
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    public void addItem(Item item, int quantity) {
        String name = item.getName();

        if (quantity <= 0) {
            Utils.print("Cannot add zero or negative quantities. Please try again.");
            return;
        }

        for (int i = 0; i < quantity; i++) {
            cartItems.add(item);
        }
        Utils.print(quantity + " " + name + " items added to your Cart");
    }

    public void removeItem(String itemName, int quantity) {
        if (isCartEmpty()) {
            Utils.print("The cart is empty");
            return;
        }

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

    public void displayCart() {
        if (isCartEmpty()) {
            Utils.print("The cart is empty");
            return;
        }

        Result result = calculateSubtotal();
        Map<Item, Integer> items = result.getItemQuantities();
        double subtotal = result.getSubtotal();

        Utils.print("~*~*~*~Shopping Cart~*~*~*~");

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            double total = item.getPrice() * quantity;

        System.out.printf("%-20s $%5.2f x%-3d= $%6.2f%n", item.getName(), item.getPrice(), quantity, total);
        }
        System.out.printf("\nSubtotal:%32s%n", String.format("$%6.2f", subtotal));
    }

    public void checkout() {

        if (isCartEmpty()) {
            Utils.print("The cart is empty");
            return;
        }

        Result result = calculateSubtotal();
        Map<Item, Integer> items = result.getItemQuantities();
        double subtotal = result.getSubtotal();

        Utils.print("~*~*~*~Shopping Cart~*~*~*~");

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            double total = item.getPrice() * quantity;

            System.out.printf("%-20s $%5.2f x%-3d= $%6.2f%n", item.getName(), item.getPrice(), quantity, total);
        }
        System.out.printf("\nSubtotal:%32s%n", String.format("$%6.2f", subtotal));

        double taxRate = 0.082;
        double salesTax = subtotal * taxRate;
        double total = subtotal + salesTax;

        System.out.printf("Sales Tax (8.2%%): %23s%n", String.format("$%6.2f", salesTax));
        System.out.printf("Total:%35s%n", String.format("$%6.2f", total));

        cartItems.clear();
        Utils.print("\nCheckout process complete.");
    }

    public Result calculateSubtotal() {
        Map<Item, Integer> itemQuantities = new HashMap<>();
        double subtotal = 0.0;

        for(Item item : cartItems) {
            itemQuantities.put(item, itemQuantities.getOrDefault(item, 0) +1);
            subtotal += item.getPrice();
        }
        return new Result(itemQuantities, subtotal);
    }

    // getter for CartItems for use in tests
    public List<Item> getCartItems() {
        return cartItems;
    }
}