package com.classicbit.inventory.view;

import com.classicbit.inventory.model.CartItem;
import com.classicbit.inventory.model.Console;
import com.classicbit.inventory.model.Product;
import com.classicbit.inventory.model.RareConsole;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class KioskIO {
    private final Scanner scanner;

    public KioskIO() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcome() {
        System.out.println("========================================");
        System.out.println("     Welcome to the ClassicBit Kiosk!   ");
        System.out.println("========================================");
    }

    public void displayGoodbye() {
        System.out.println();
        System.out.println("Thank you for using the ClassicBit Kiosk!");
        System.out.println("Come back soon!");
    }

    public int displayMenuAndGetChoice() {
        System.out.println();
        System.out.println("=== MAIN MENU ===");
        System.out.println("1. Add console to cart");
        System.out.println("2. Remove console from cart");
        System.out.println("3. View cart");
        System.out.println("4. Checkout");
        System.out.println("5. Quit");
        System.out.println();

        return getIntegerInputWithDefault("Please select an option (1-5): ", -1);
    }

    public void displaySectionHeader(String title) {
        System.out.println();
        System.out.println("=== " + title.toUpperCase() + " ===");
    }

    public void displaySuccess(String message) {
        System.out.println("✓ " + message);
    }

    public void displayError(String message) {
        System.out.println("✗ ERROR: " + message);
    }

    public void displayInfo(String message) {
        System.out.println("ℹ " + message);
    }

    public void displayCartContents(List<CartItem> cartContents) {
        System.out.println("═════════════════════════════════════════════════════════════════════════");
        System.out.println("                             SHOPPING CART");
        System.out.println("═════════════════════════════════════════════════════════════════════════");

        if (cartContents.isEmpty()) {
            System.out.println("                            Your cart is empty");
            System.out.println("═════════════════════════════════════════════════════════════════════════");
            return;
        }

        System.out.printf("%-10s %-35s %3s %12s%n", "ID", "NAME", "QTY", "TOTAL");
        System.out.println("─────────────────────────────────────────────────────────────────────────");

        for (CartItem item : cartContents) {
            Product product = item.getProduct();
            Console console;

            if (product instanceof Console c) {
                console = c;
            } else if (product instanceof RareConsole rare) {
                console = rare.baseConsole(); // extract Console
            } else {
                displayError("Unknown product type.");
                continue;
            }

            String id = console.id();
            String name = console.name();
            int quantity = item.getQuantity();
            BigDecimal extendedPrice = item.getExtendedPrice();


            if (name.length() > 35) {
                name = name.substring(0, 32) + "...";
            }

            System.out.printf("%-10s %-35s %3d     $%8.2f%n", id, name, quantity, extendedPrice);
        }

        System.out.println("═════════════════════════════════════════════════════════════════════════");
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            displayError("Input cannot be empty. Please try again.");
            return getStringInput(prompt);
        }
        return input;
    }

    public Integer getIntegerInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                displayError("Please enter a positive number.");
                return getIntegerInput(prompt);
            }
            return value;
        } catch (NumberFormatException e) {
            displayError("Invalid number. Please try again.");
            return getIntegerInput(prompt);
        }
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
            displayError("Please enter a valid number.");
            return getIntegerInputWithDefault(prompt, defaultValue);
        }
    }

    public boolean getConfirmation(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();

        while (!input.equals("y") && !input.equals("n") &&
                !input.equals("yes") && !input.equals("no")) {
            displayError("Please enter 'y' for yes or 'n' for no.");
            System.out.print(prompt);
            input = scanner.nextLine().trim().toLowerCase();
        }

        return input.equals("y") || input.equals("yes");
    }

}
