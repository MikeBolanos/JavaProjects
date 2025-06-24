package com.shoppinginc.models;

import java.util.Map;

public class Result {
    private final Map<Item, Integer> itemQuantities;
    private final double subtotal;

    public Result(Map<Item, Integer> itemQuantities, double subtotal) {
        this.itemQuantities = itemQuantities;
        this.subtotal = subtotal;
    }

    public Map<Item, Integer> getItemQuantities() {
        return itemQuantities;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
