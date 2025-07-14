package com.classicbit.inventory.command;

import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.service.InventoryService;
import com.classicbit.inventory.ui.AdminInventoryIO;

public class ViewItemCommand implements Command {
    private final InventoryService inventoryService;
    private final AdminInventoryIO adminIO;

    public ViewItemCommand(InventoryService inventoryService, AdminInventoryIO adminIO) {
        this.inventoryService = inventoryService;
        this.adminIO = adminIO;
    }

    @Override
    public void execute() {
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
}
