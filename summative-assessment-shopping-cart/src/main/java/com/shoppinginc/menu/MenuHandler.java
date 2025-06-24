package com.shoppinginc.menu;

import com.shoppinginc.models.*;
import com.shoppinginc.services.CartService;

public class MenuHandler {
    private final Catalog catalog;
    private final CartService cartService;

    public MenuHandler(Catalog catalog, CartService cartService) {
        this.catalog = catalog;
        this.cartService = cartService;
    }

    public boolean handle(MenuOption option) {
        
    }
}
