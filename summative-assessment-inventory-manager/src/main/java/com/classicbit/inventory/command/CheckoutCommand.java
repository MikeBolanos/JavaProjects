package com.classicbit.inventory.command;

import com.classicbit.inventory.model.Result;
import com.classicbit.inventory.service.CartService;
import com.classicbit.inventory.view.KioskIO;

public class CheckoutCommand implements Command {
    private final CartService cartService;
    private final KioskIO kioskIO;

    public CheckoutCommand(CartService cartService, KioskIO kioskIO) {
        this.cartService = cartService;
        this.kioskIO = kioskIO;
    }

    @Override
    public void execute() {
        if (cartService.isEmpty()) {
            kioskIO.displayInfo("Cart is empty. Nothing to checkout.");
            return;
        }

        kioskIO.displaySectionHeader("Checkout");
        new ViewCartCommand(cartService, kioskIO).execute();

        boolean confirm = kioskIO.getConfirmation("Proceed with checkout? (y/n): ");
        if (!confirm) {
            kioskIO.displayInfo("Checkout cancelled.");
            return;
        }

        Result<String> result = cartService.checkout();

        if (result.isSuccess()) {
            kioskIO.displaySuccess(result.getMessage());
        } else {
            kioskIO.displayError("Checkout failed: " + result.getMessage());
        }
    }
}
