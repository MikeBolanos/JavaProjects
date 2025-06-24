package com.shoppinginc.app;

import com.shoppinginc.interfaces.CartCommands;
import com.shoppinginc.utils.Utils;
import com.shoppinginc.models.*;
import com.shoppinginc.services.CartService;


public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        CartCommands cart = new CartService(catalog);

        boolean looping;

        do {

            // Header
            Utils.print("\n~*~*~*~Shopping Inc Menu~*~*~*~");
            // Display Menu
            Utils.print("1. View Catalog");
            Utils.print("2. Add Item to Cart");
            Utils.print("3. Remove Item from Cart");
            Utils.print("4. View Cart");
            Utils.print("5. Checkout");
            Utils.print("6. Exit");

            int choice = Utils.promptInt("\nEnter your choice via number (1-6): ");

            switch (choice) {
                // 1. View Catalog
                case 1 -> catalog.displayCatalog();

                // 2. Add Item
                case 2 -> {
                    String name = Utils.promptString("Enter an item from the Catalog: ").trim();
                    Item item = catalog.getItemByName(name);
                    if (item == null) {
                        Utils.print("Item not found");
                    } else {
                        int quantity = Utils.promptInt("Enter quantity: ");
                        cart.addItem(item, quantity);
                    }
                }

                // 3. Remove item
                case 3 -> {
                    cart.displayCart();
                    String name = Utils.promptString("Enter an item to remove from the Cart: ").trim();
                    int quantity = Utils.promptInt("Enter the quantity to remove: ");
                    cart.removeItem(name, quantity);
                }

                // 4. View Cart
                case 4 -> {
                    cart.displayCart();
                }

                // 5. Checkout
                case 5 -> {
                cart.checkout();
                }

                // 6. Exit
                case 6 -> {
                    Utils.print("Thank you for shopping with Shopping Inc!");
                    Utils.print("Goodbye!");
                }
                default -> Utils.print("Invalid choice. Please try again.");
            }
            looping = (choice != 6);

        } while (looping);

    }
}

