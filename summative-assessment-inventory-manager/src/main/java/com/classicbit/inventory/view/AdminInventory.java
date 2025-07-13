package com.classicbit.inventory.view;

import org.springframework.stereotype.Component;

@Component
public class AdminInventory {
    // Inject InventoryService and AdminInventoryIO

    public void run() {
        // display welcome message

        // loop until user chooses to quit:
        // display menu and get user choice

        // switch(choice):
        // case 1: handleAddOrUpdateItem()
        // case 2: handleRemoveItem()
        // case 3: handleViewItem()
        //case 4: handleViewAllItems()
        // case 5: display goodbye message, exit loop
        // default: display invalid option
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
