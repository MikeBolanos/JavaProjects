package com.classicbit.inventory.command;

import com.classicbit.inventory.model.CartItem;
import com.classicbit.inventory.model.Result;
import com.classicbit.inventory.service.CartService;
import com.classicbit.inventory.view.KioskIO;

import java.math.BigDecimal;
import java.util.List;

public class ViewCartCommand implements Command {
    private final CartService cartService;
    private final KioskIO kioskIO;

    public ViewCartCommand(CartService cartService, KioskIO kioskIO) {
        this.cartService = cartService;
        this.kioskIO = kioskIO;
    }

    @Override
    public void execute() {
        kioskIO.displaySectionHeader("Cart Contents");

        if (cartService.isEmpty()) {
            kioskIO.displayInfo("Cart is empty.");
            return;
        }

        List<CartItem> cartItems = cartService.getCartContents();
        kioskIO.displayCartContents(cartItems);

        Result<BigDecimal> totalResult = cartService.getTotalPrice();
        if (totalResult.isSuccess()) {
            kioskIO.displayInfo(String.format("Total: $%.2f", totalResult.getData()));
        } else {
            kioskIO.displayError("Error calculating total: " + totalResult.getMessage());
        }
    }
}
