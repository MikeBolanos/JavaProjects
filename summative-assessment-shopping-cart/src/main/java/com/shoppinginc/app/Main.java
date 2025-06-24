package com.shoppinginc.app;

import com.shoppinginc.commands.*;
import com.shoppinginc.utils.Utils;
import com.shoppinginc.models.*;
import com.shoppinginc.services.CartService;


public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        CartService cartService = new CartService();

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
                        Command<Void> addCommand = new AddItemCommand(cartService, item, quantity);
                        addCommand.execute();
                    }
                }

                // 3. Remove item
                case 3 -> {
                    Command<Boolean> isEmptyCommand = new IsCartEmptyCommand(cartService);
                    if (isEmptyCommand.execute()) {
                        Utils.print("The cart is empty.");
                        break;
                    }
                    String name = Utils.promptString("Enter an item to remove from the Cart: ").trim();
                    int quantity = Utils.promptInt("Enter the quantity to remove: ");
                    Command<Void> removeCommand = new RemoveItemCommand(cartService, name, quantity);
                    removeCommand.execute();
                }

                // 4. View Cart
                case 4 -> {
                    Command<Void> displayCommand = new DisplayCartCommand(cartService);
                    displayCommand.execute();
                }

                // 5. Checkout
                case 5 -> {
                    Command<Void> checkoutCommand = new CheckoutCommand(cartService);
                checkoutCommand.execute();
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