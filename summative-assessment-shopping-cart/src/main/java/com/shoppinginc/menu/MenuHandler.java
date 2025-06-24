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
    }
}
