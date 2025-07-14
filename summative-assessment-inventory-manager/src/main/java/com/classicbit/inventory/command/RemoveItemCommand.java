package com.classicbit.inventory.command;

import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.service.InventoryService;
import com.classicbit.inventory.ui.AdminInventoryIO;

import java.util.List;

public class RemoveItemCommand implements Command {
    private final InventoryService inventoryService;
    private final AdminInventoryIO adminIO;

    public RemoveItemCommand(InventoryService inventoryService, AdminInventoryIO adminIO) {
        this.inventoryService = inventoryService;
        this.adminIO = adminIO;
    }
    @Override
    public void execute() {
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
}
