package com.shoppinginc.menu;

import java.awt.*;

public enum MenuOption {

    VIEW_CATALOG(1, "View Catalog"),
    ADD_ITEM(2, "Add Item to Cart"),
    REMOVE_ITEM(3, "Remove Item from Cart"),
    VIEW_CART(4, "View Cart"),
    CHECKOUT(5, "Checkout"),
    EXIT(6, "Exit");

    private final int number;
    private final String tag;

    MenuOption(int number, String tag) {
        this.number = number;
        this.tag = tag;
    }

    public int getNumber() {
        return number;
    }

    public String getTag() {
        return tag;
    }

    public static MenuOption numberChoice(int number) {
        for (MenuOption option : values()) {
            if (option.number == number) {
                return option;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return number + ". " + tag;
    }
}
