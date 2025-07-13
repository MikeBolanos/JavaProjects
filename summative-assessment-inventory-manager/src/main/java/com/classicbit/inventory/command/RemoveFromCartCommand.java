package com.classicbit.inventory.command;

import com.classicbit.inventory.model.Result;
import com.classicbit.inventory.service.CartService;
import com.classicbit.inventory.view.KioskIO;

public class RemoveFromCartCommand implements Command {
    private final CartService cartService;
    private final KioskIO kioskIO;

    public RemoveFromCartCommand(CartService cartService, KioskIO kioskIO) {
        this.cartService = cartService;
        this.kioskIO = kioskIO;
    }

    @Override
    public void execute() {
        if (cartService.isEmpty()) {
            kioskIO.displayInfo("Cart is empty. Nothing to remove.");
            return;
        }

        kioskIO.displaySectionHeader("Remove Console from Cart");
        // Show current cart
        kioskIO.displayCartContents(cartService.getCartContents());

        String id = kioskIO.getStringInput("Enter Console ID to remove: ");
        if (id == null) return;

        Integer quantity = kioskIO.getIntegerInput("Enter quantity to remove: ");
        if (quantity == null) return;

        Result<Void> result = cartService.removeFromCart(id, quantity);

        if (result.isSuccess()) {
            kioskIO.displaySuccess(result.getMessage());
        } else {
            kioskIO.displayError(result.getMessage());
        }
    }
}
