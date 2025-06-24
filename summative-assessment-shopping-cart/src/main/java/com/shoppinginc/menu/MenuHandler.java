package com.shoppinginc.menu;

import com.shoppinginc.commands.*;
import com.shoppinginc.models.*;
import com.shoppinginc.services.CartService;
import com.shoppinginc.utils.Utils;

public class MenuHandler {
    private final Catalog catalog;
    private final CartService cartService;

    public MenuHandler(Catalog catalog, CartService cartService) {
        this.catalog = catalog;
        this.cartService = cartService;
    }

    public boolean handle(MenuOption option) {
        switch (option) {
            case VIEW_CATALOG -> catalog.displayCatalog();

            case ADD_ITEM -> {
                String name = Utils.promptString("Enter an item from the Catalog: ").trim();
                Item item = catalog.getItemByName(name);
                if (item == null) {
                    Utils.print("Item not found");
                } else {
                    int quantity = Utils.promptInt("Enter quantity: ");
                    new AddItemCommand(cartService, item, quantity).execute();
                }
            }
            case REMOVE_ITEM -> {
                if (new IsCartEmptyCommand(cartService).execute()) {
                    Utils.print("The cart is empty");
                    return true;
                }

                String name = Utils.promptString("Enter an item to remove from the Cart: ").trim();
                int quantity = Utils.promptInt("Enter the quantity to remove: ");
                new RemoveItemCommand(cartService, name, quantity).execute();
            }

            case VIEW_CART -> new DisplayCartCommand(cartService).execute();

            case CHECKOUT -> new CheckoutCommand(cartService).execute();

            case EXIT -> {
                Utils.print("Thank you for shopping with Shopping Inc!");
                Utils.print("Goodbye!");
                return false;
            }
            default -> Utils.print("Invalid choice. Please try again.");
        }
        return true;
    }
}
