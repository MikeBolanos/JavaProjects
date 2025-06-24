package com.shoppinginc.app;

import com.shoppinginc.interfaces.CartCommands;
import com.shoppinginc.utils.Utils;
import com.shoppinginc.models.*;
import com.shoppinginc.services.CartService;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        CartCommands cart = new CartService(catalog);

        


    }

