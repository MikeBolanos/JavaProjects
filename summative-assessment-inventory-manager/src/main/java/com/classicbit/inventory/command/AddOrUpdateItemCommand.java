package com.classicbit.inventory.command;

import com.classicbit.inventory.model.Console;
import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.model.Product;
import com.classicbit.inventory.model.RareConsole;
import com.classicbit.inventory.service.InventoryService;
import com.classicbit.inventory.view.AdminInventoryIO;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class AddOrUpdateItemCommand implements Command {
    private final InventoryService inventoryService;
    private final AdminInventoryIO adminIO;

    @Autowired
    public AddOrUpdateItemCommand(InventoryService inventoryService, AdminInventoryIO adminIO) {
        this.inventoryService = inventoryService;
        this.adminIO = adminIO;
    }

    @Override
    public void execute() {
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
}
