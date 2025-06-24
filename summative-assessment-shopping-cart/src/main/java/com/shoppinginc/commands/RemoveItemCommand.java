package com.shoppinginc.commands;

import com.shoppinginc.services.CartService;

public class RemoveItemCommand implements Command {
        private final CartService cartService;
        private final String itemName;
        private final int quantity;

        public RemoveItemCommand (CartService cartService, String itemName, int quantity) {
            this.cartService = cartService;
            this.itemName = itemName;
            this.quantity = quantity;
        }

        @Override
        public Void execute() {
            cartService.removeItem(itemName, quantity);
            return null;
        }
}
