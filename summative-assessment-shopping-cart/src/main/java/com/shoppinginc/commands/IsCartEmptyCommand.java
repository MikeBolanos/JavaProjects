package com.shoppinginc.commands;

import com.shoppinginc.services.CartService;

public class IsCartEmptyCommand implements Command {
    private final CartService cartService;

    public IsCartEmptyCommand (CartService cartService) {
        this.cartService = cartService;
    }
    @Override
    public Boolean execute() {
        return cartService.isCartEmpty();
    }
}
