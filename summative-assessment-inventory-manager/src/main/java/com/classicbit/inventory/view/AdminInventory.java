package com.classicbit.inventory.view;

import com.classicbit.inventory.command.*;
import com.classicbit.inventory.model.*;

import com.classicbit.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class AdminInventory {
    // Inject InventoryService and AdminInventoryIO
    private final InventoryService inventoryService;
    private final AdminInventoryIO adminIO;

    private final Map<Integer, Command> commands = new LinkedHashMap<>();

    @Autowired
    public AdminInventory(InventoryService inventoryService, AdminInventoryIO adminIO) {
        this.inventoryService = inventoryService;
        this.adminIO = adminIO;

        commands.put(1, new AddOrUpdateItemCommand(inventoryService, adminIO));
        commands.put(2, new RemoveItemCommand(inventoryService, adminIO));
        commands.put(3, new ViewItemCommand(inventoryService, adminIO));
        commands.put(4, new ViewAllItemsCommand(inventoryService, adminIO));
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
                case 1,2,3,4 -> {
                    Command command = commands.get(choice);
                    if (command !=null) {
                        command.execute();
                    } else {
                        adminIO.displayError("Command not found");
                    }
                }

                case 5 -> {
                    running = false;
                    adminIO.displayGoodbye();
                }
                default -> adminIO.displayError("Invalid choice. Please select a valid option");
            }
        }
    }
}