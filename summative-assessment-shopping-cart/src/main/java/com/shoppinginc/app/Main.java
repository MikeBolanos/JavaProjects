package com.shoppinginc.app;

import com.shoppinginc.interfaces.CartCommands;
import com.shoppinginc.utils.Utils;
import com.shoppinginc.models.*;
import com.shoppinginc.services.CartService;
import jdk.jshell.execution.Util;

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

            int choice = Utils.promptInt("Enter your choice via number(1-6)");

            switch (choice) {
                // 1. View Catalog
                case 1 -> catalog.displayCatalog();

                // 2. Add Item
                case 2 -> {
                    String name = Utils.promptString("Enter an item from the Catalog");
                    Item item = catalog.getItemByName(name);
                    if (item == null) {
                        Utils.print("Item not found");
                    } else {
                        int quantity = Utils.promptInt("Enter quantity");
                        cart.addItem(item, quantity);
                    }
                }
                // 3. Remove item

                // 4. View Cart

                // 5. Checkout

                // 6. Exit
                case 6 -> {
                    Utils.print("Thank you for shopping with Shopping Inc!");
                    break;
                }
                default -> Utils.print("Invalid choice. Please try again.");
            }
            looping = (choice != 6);

        } while (looping);

    }
}

