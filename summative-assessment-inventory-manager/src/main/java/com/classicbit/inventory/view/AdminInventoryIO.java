package com.classicbit.inventory.view;

import com.classicbit.inventory.model.Console;
import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.model.Product;
import com.classicbit.inventory.model.RareConsole;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class AdminInventoryIO {
    // Scanner for user input
    private final Scanner scanner;

    public AdminInventoryIO() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcome() {
        // print welcome header
        System.out.println();
        System.out.println("================================================");
        System.out.println("  Welcome to the ClassicBit Inventory Manager!  ");
        System.out.println("================================================");
    }

    public void displayGoodbye() {
        // print goodbye message
        System.out.println("\nThank you for using the ClassicBit Admin Inventory Manager!");
        System.out.println("Have a great day!");
        System.out.println();
    }

    public int displayMenuAndGetChoice() {
        // print numbered menu
        System.out.println("\n~*~*~*~ Admin Inventory Management Menu ~*~*~*~");
        System.out.println("1. Add or Update inventory item");
        System.out.println("2. Remove inventory item");
        System.out.println("3. View inventory item by ID");
        System.out.println("4. View all inventory items");
        System.out.println("5. Quit");
        System.out.println();
        // return get user input as int
        return getIntegerInputWithDefault("Please select an option (1-5): ", -1);
    }
    public void displaySectionHeader(String title) {
        // visually separate sections (like "=== ADD ITEM ===")
        System.out.println("\n=== " + title.toUpperCase() + " ===");
    }

    public void displaySuccess(String message) {
        // print nicely formatted messages
        System.out.println("✓" + message);
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void displayInfo(String message) {
        System.out.println("ℹ " + message);
    }

    private int getIntegerInputWithDefault(String prompt, int defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            displayError("Please enter a valid number");
            return getIntegerInputWithDefault(prompt, defaultValue);
        }
    }

    public void displayInventoryItems(List<InventoryItem> items) {
        // print table headers
        // print each item: ID, name, type, quantity, price, etc.
        System.out.println("═════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                INVENTORY LIST");
        System.out.println("═════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-10s %-30s %-15s %-12s %6s %10s%n", "ID", "NAME", "MAKER", "REGION", "QTY", "PRICE");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────────");

        for (InventoryItem item : items) {
            Product product = item.getProduct();
            Console console;

            // Check and extract Console info
            if (product instanceof Console c) {
                console = c;
            } else if (product instanceof RareConsole rare) {
                console = rare.baseConsole(); // get the wrapped Console
            } else {
                displayError("Unknown product type.");
                continue;
            }

            String id = console.id();
            String name = console.name();
            String maker = console.manufacturer();
            String region = console.regionLock();
            int quantity = item.getQuantity();
            BigDecimal price = item.getPrice();

            if (name.length() > 30) {
                name = name.substring(0, 27) + "...";
            }

            System.out.printf("%-10s %-30s %-15s %-12s %5d   $%8.2f%n",
                    id, name, maker, region, quantity, price);
        }

        System.out.println("═════════════════════════════════════════════════════════════════════════════════════════");

    }

    public void displaySingleItem(InventoryItem item) {
        // print detailed view of one item
        System.out.println("\n══════════════════════════════════════════════════════════════════════════════");
        System.out.println("                               ITEM DETAILS");
        System.out.println("══════════════════════════════════════════════════════════════════════════════");

        Product product = item.getProduct();
        Console console;

        if (product instanceof Console c) {
            console = c;
        } else if (product instanceof RareConsole rare) {
            console = rare.baseConsole();
        } else {
            displayError("Unknown product type.");
            return;
        }

        System.out.printf("ID:              %s%n", console.id());
        System.out.printf("Name:            %s%n", console.name());
        System.out.printf("Manufacturer:    %s%n", console.manufacturer());
        System.out.printf("Release Year:    %s%n", console.releaseYear());
        System.out.printf("Region Lock:     %s%n", console.regionLock());
        System.out.printf("Quantity:        %d%n", item.getQuantity());
        System.out.printf("Price:           $%.2f%n", item.getPrice());

        if (product instanceof RareConsole rare) {
            System.out.printf("Rarity:          %s%n", rare.rarity());
            System.out.printf("Certificate:     %s%n", rare.certificate());
        }

        System.out.println("══════════════════════════════════════════════════════════════════════════════");
    }

    public String getStringInput(String prompt) {
        // print prompt
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        // read input, validate it's not empty
        if (input.isEmpty()) {
            displayError("Input cannot be empty.");
            return getStringInput(prompt);
        }
        // return value
            return input;
        }

    public Integer getIntegerInput(String prompt){
            // print prompt
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            // read input, validate it's a positive int
            // return value
            try {
                int val = Integer.parseInt(input);
                if (val <= 0) {
                    displayError("Value must be positive.");
                    return getIntegerInput(prompt);
                }
                return val;
            } catch (NumberFormatException e) {
                displayError("Invalid number. Please try again.");
                return getIntegerInput(prompt);
            }
        }

    public BigDecimal getBigDecimalInput(String prompt) {
        // print prompt
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        // read input, validate it’s a valid decimal
        // return value
        try {
            BigDecimal value = new BigDecimal(input);
            if (value.compareTo(BigDecimal.ZERO) <= 0) {
                displayError("Price must be positive.");
                return getBigDecimalInput(prompt);
            }
            return value;
        } catch (NumberFormatException e) {
            displayError("Invalid price format.");
            return getBigDecimalInput(prompt);
        }
    }

    public boolean getConfirmation(String prompt) {
        // prompt user with (y/n)
        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        // return true if user enters yes
        while (!input.equals("y") && !input.equals("n") &&
                !input.equals("yes") && !input.equals("no")) {
            displayError("Please enter 'y' or 'n'.");
            System.out.print(prompt);
            input = scanner.nextLine().trim().toLowerCase();
        }
        return input.equals("y") || input.equals("yes");
    }
}