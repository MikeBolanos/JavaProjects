package com.shoppinginc.commands;
import com.shoppinginc.models.Item;
import com.shoppinginc.services.CartService;

public class AddItemCommand implements Command {
    private final CartService cartService;
    private final Item item;
    private final int quantity;

    public AddItemCommand (CartService cartService, Item item, int quantity) {
        this.cartService = cartService;
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public Void execute() {
        cartService.addItem(item, quantity);
        return null;
    }
}
