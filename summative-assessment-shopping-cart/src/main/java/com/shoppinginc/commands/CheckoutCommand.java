package com.shoppinginc.commands;


import com.shoppinginc.services.CartService;

public class CheckoutCommand implements Command {
    private final CartService cartService;

    public CheckoutCommand(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public Void execute() {
        cartService.checkout();
        return null;
    }

}
