package com.classicbit.inventory.view;

import com.classicbit.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminInventory {
    // Inject InventoryService and AdminInventoryIO
    private final InventoryService inventoryService;
    private final AdminInventoryIO adminIO;

    @Autowired
    public AdminInventory(InventoryService inventoryService, AdminInventoryIO adminIO);

    public void run() {
        // display welcome message
        adminIO.displayWelcome();

        // loop until user chooses to quit:
        boolean running = true;
        while (running) {
            // display menu and get user choice
            int choice = adminIO.displayMenuAndGetChoice();
            switch (choice) {
                case 1:
                    handleAddOrUpdateItem();
                    break;

                case 2:
                    handleRemoveItem();
                    break;

                case 3:
                    handleViewItem();
                    break;

                case 4:
                    handleViewAllItems();
                    break;

                case 5:
                    running = false;
                    adminIO.displayGoodbye();
                    break;
                default:
                    adminIO.displayError("Invalid choice. Please try again");
            }
        }
    }

    private void handleAddOrUpdateItem() {
        // prompt for ID, name, type, quantity, price

        // create Product (Console or RareConsole)
        // wrap in InventoryItem

        // call inventoryService.getItem(id)
        // if exists → it's an update
        // call inventoryService.updateOrAddItem(item)

        // show success or error
    }

    private void handleRemoveItem() {
        // display list of items
        // prompt for ID to remove
        // confirm with user
        // if confirmed → call inventoryService.removeItem(id)
        // show success or error
    }

    private void handleViewItem() {
        // prompt for ID
        // get item from service
        // if found → display item
       // else → show error
    }

    private void handleViewAllItems() {
        // get list of items from service
        // display each item using AdminInventoryIO
    }
}

}
