package com.classicbit.inventory.ui;


import com.classicbit.inventory.command.*;
import com.classicbit.inventory.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Kiosk {
    private final CartService cartService;
    private final KioskIO kioskIO;
    private final Map<Integer, Command> commands = new LinkedHashMap<>();

    @Autowired
    public Kiosk(CartService cartService, KioskIO kioskIO) {
        this.cartService = cartService;
        this.kioskIO = kioskIO;

    // Initialize commands for Kiosk menu
        commands.put(1, new AddToCartCommand(cartService, kioskIO));
        commands.put(2, new RemoveFromCartCommand(cartService, kioskIO));
        commands.put(3, new ViewCartCommand(cartService, kioskIO));
        commands.put(4, new CheckoutCommand(cartService, kioskIO));
}

    public void run() {
        kioskIO.displayWelcome();

        boolean running = true;
        while (running) {
            int choice = kioskIO.displayMenuAndGetChoice();

            switch (choice) {
                case 1,2,3,4 -> {
                    Command command = commands.get(choice);
                    if (command !=null ) {
                        command.execute();
                    } else {
                        kioskIO.displayError("Command not found");
                    }
                }

                case 5 -> {
                    running = false;
                    kioskIO.displayGoodbye();
                }
                default -> kioskIO.displayError("Invalid choice. Please try again.");
            }
        }
    }
}
