package com.classicbit.inventory.command;

import com.classicbit.inventory.model.Result;
import com.classicbit.inventory.service.CartService;
import com.classicbit.inventory.view.KioskIO;

public class AddToCartCommand implements Command {
    private final CartService cartService;
    private final KioskIO kioskIO;

    public AddToCartCommand(CartService cartService, KioskIO kioskIO) {
        this.cartService = cartService;
        this.kioskIO = kioskIO;
    }

    @Override
    public void execute() {
        kioskIO.displaySectionHeader("Add Console to Cart");

        String id = kioskIO.getStringInput("Enter Console ID: ");
        if (id == null) return;

        Integer quantity = kioskIO.getIntegerInput("Enter quantity: ");
        if (quantity == null) return;

        Result<Void> result = cartService.addToCart(id, quantity);

        if (result.isSuccess()) {
            kioskIO.displaySuccess(result.getMessage());
        } else {
            kioskIO.displayError(result.getMessage());
        }
    }
}
