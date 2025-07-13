package com.classicbit.inventory.view;

import com.classicbit.inventory.model.Console;
import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.model.Product;
import com.classicbit.inventory.model.RareConsole;
import com.classicbit.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class AdminInventory {
    // Inject InventoryService and AdminInventoryIO
    private final InventoryService inventoryService;
    private final AdminInventoryIO adminIO;

    @Autowired
    public AdminInventory(InventoryService inventoryService, AdminInventoryIO adminIO) {
        this.inventoryService = inventoryService;
        this.adminIO = adminIO;
    }

    public void run() {
        // display welcome message
        adminIO.displayWelcome();

        // loop until user chooses to quit:
        boolean running = true;
        while (running) {
            // display menu and get user choice
            int choice = adminIO.displayMenuAndGetChoice();
            switch (choice) {
                case 1 -> handleAddOrUpdateItem();

                case 2 -> handleRemoveItem();

                case 3 -> handleViewItem();

                case 4 -> handleViewAllItems();

                case 5 -> {
                    running = false;
                    adminIO.displayGoodbye();
                }

                default -> adminIO.displayError("Invalid choice. Please select a valid option");
            }
        }
    }

    private void handleAddOrUpdateItem() {
        adminIO.displaySectionHeader("Add or Update Inventory Item");

        // prompt for ID, name, manufacturer, releaseYear, regionLock, quantity, price, rarity
        String id = adminIO.getStringInput("Enter Console ID: ");
        if (id == null) return;

        String name = adminIO.getStringInput("Enter Console Name: ");
        if (name == null) return;

        String manufacturer = adminIO.getStringInput("Enter Manufacturer: ");
        if (manufacturer == null) return;

        String releaseYear = adminIO.getStringInput("Enter Release Year: ");
        if (releaseYear == null) return;

        String regionLock = adminIO.getStringInput("Enter Region Lock: ");
        if (regionLock == null) return;

        Integer quantity = adminIO.getIntegerInput("Enter quantity: ");
        if (quantity == null) return;

        BigDecimal price = adminIO.getBigDecimalInput("Enter price: ");
        if (price == null) return;

        boolean isRare = adminIO.getConfirmation("Is this a rare console? (y/n): ");

        // create Product (Console or RareConsole)
        Product product;
        if (isRare) {
            String rarity = adminIO.getStringInput("Enter rarity info: ");
            if (rarity == null) return;

            String certificate = adminIO.getStringInput("Enter certificate info: ");
            if (certificate == null) return;

            Console baseConsole = new Console(id, name, manufacturer, releaseYear, regionLock);
            product = new RareConsole(baseConsole, rarity, certificate);
        } else {
            product = new Console(id, name, manufacturer, releaseYear, regionLock);
        }
        // wrap in InventoryItem
        InventoryItem existingItem = inventoryService.getItem(id);
        InventoryItem newItem = new InventoryItem(product, quantity, price);

        // call inventoryService.getItem(id)
        inventoryService.updateOrAddItem(newItem);

        // if exists, show success or error
        if (existingItem != null) {
            adminIO.displaySuccess("Item updated successfully.");
        } else {
            adminIO.displaySuccess("Item added successfully.");
        }
    }

    private void handleRemoveItem() {
        adminIO.displaySectionHeader("Remove Inventory Item");
        List<InventoryItem> allItems = inventoryService.getAllItems(); // "" for placeholder, since your method takes an id (even if unused)
        if (allItems.isEmpty()) {
            adminIO.displayInfo("Inventory is empty. Nothing to remove.");
            return;
        }
            // Show all items
            adminIO.displayInventoryItems(allItems);
            // Prompt for ID to remove
            String id = adminIO.getStringInput("Enter ID of item to remove: ");
            InventoryItem item = inventoryService.getItem(id);

            if (item == null) {
                adminIO.displayError("Item with ID '" + id + "' not found.");
                return;
            }

            adminIO.displaySectionHeader("Item to Remove");
            adminIO.displaySingleItem(item);

            // confirm with user
            boolean confirm = adminIO.getConfirmation("Are you sure you want to remove this item? (y/n): ");
            if (!confirm) {
                adminIO.displayInfo("Item removal canceled.");
                return;
            }

            // if confirmed → call inventoryService.removeItem(id)
            inventoryService.removeItem(id);
            // show success or error
            adminIO.displaySuccess("Item removed successfully.");
        }

    private void handleViewItem() {
            adminIO.displaySectionHeader("View Inventory Item");
        // prompt for ID
        String id = adminIO.getStringInput("Enter ID to search: ");
        // get item from service
        InventoryItem item = inventoryService.getItem(id);
        // if found → display item
        if (item == null) {
            adminIO.displayError("Item with ID '" + id + "' not found.");
        } else {
            adminIO.displaySingleItem(item);
        }
    }

    private void handleViewAllItems() {
        adminIO.displaySectionHeader("All Inventory Items");
        // get list of items from service
        List<InventoryItem> items = inventoryService.getAllItems();
        if (items.isEmpty()) {
            adminIO.displayInfo("No inventory items to display.");
        } else {
            // display each item
            adminIO.displayInventoryItems(items);
            adminIO.displayInfo("Total items: " + items.size());
        }
    }
}
