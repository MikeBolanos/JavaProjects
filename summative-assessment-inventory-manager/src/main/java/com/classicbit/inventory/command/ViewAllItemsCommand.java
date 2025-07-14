package com.classicbit.inventory.command;

import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.service.InventoryService;
import com.classicbit.inventory.ui.AdminInventoryIO;

import java.util.List;

public class ViewAllItemsCommand implements Command {
    private final InventoryService inventoryService;
    private final AdminInventoryIO adminIO;

    public ViewAllItemsCommand(InventoryService inventoryService, AdminInventoryIO adminIO) {
        this.inventoryService = inventoryService;
        this.adminIO = adminIO;
    }

    @Override
    public void execute() {
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
