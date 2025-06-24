package com.shoppinginc.Result;

import com.shoppinginc.models.Item;
import java.util.Map;

public class Result {
    private Map<Item, Integer> itemQuantities;
    private double subtotal;

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
