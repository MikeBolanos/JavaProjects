package com.shoppinginc.commands;

import com.shoppinginc.services.CartService;

public class DisplayCartCommand implements Command {
    private final CartService cartService;

    public DisplayCartCommand(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public Void execute() {
        cartService.displayCart();
        return null;
    }
}
