package com.shoppinginc.app;

import com.shoppinginc.commands.*;
import com.shoppinginc.menu.*;
import com.shoppinginc.utils.Utils;
import com.shoppinginc.models.*;
import com.shoppinginc.services.CartService;


public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        CartService cartService = new CartService();
        MenuHandler menu = new MenuHandler(catalog, cartService);

        boolean looping;

        while (looping) {
            menu.displayMenu();
        }



    }
}