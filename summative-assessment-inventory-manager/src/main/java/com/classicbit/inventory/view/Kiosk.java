package com.classicbit.inventory.view;


import com.classicbit.inventory.model.CartItem;
import com.classicbit.inventory.model.Result;
import com.classicbit.inventory.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Kiosk {
    private final CartService cartService;
    private final KioskIO kioskIO;

    @Autowired
    public Kiosk(CartService cartService, KioskIO kioskIO) {
        this.cartService = cartService;
        this.kioskIO = kioskIO;
    }

    public void run() {
        kioskIO.displayWelcome();

        boolean running = true;
        while (running) {
            int choice = kioskIO.displayMenuAndGetChoice();

            switch (choice) {
                case 1 -> handleAddToCart();

                case 2 -> handleRemoveFromCart();

                case 3 -> handleDisplayCart();

                case 4 -> handleCheckout();

                case 5 -> {
                    running = false;
                    kioskIO.displayGoodbye();
                }
                default -> kioskIO.displayError("Invalid choice. Please try again.");
            }
        }
    }

    private void handleAddToCart() {
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

    private void handleRemoveFromCart() {
        if (cartService.isEmpty()) {
            kioskIO.displayInfo("Cart is empty. Nothing to remove.");
            return;
        }

        kioskIO.displaySectionHeader("Remove Console from Cart");
        handleDisplayCart(); // Show current cart

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

    private void handleDisplayCart() {
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

    private void handleCheckout() {
        if (cartService.isEmpty()) {
            kioskIO.displayInfo("Cart is empty. Nothing to checkout.");
            return;
        }

        kioskIO.displaySectionHeader("Checkout");
        handleDisplayCart();

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
