package com.classicbit.inventory.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartItem {
    private final Console console;
    private int quantity;
    private final BigDecimal price;
    private BigDecimal extendedPrice;

    public CartItem(Console console, int quantity, BigDecimal price, BigDecimal extendedPrice) {
        this.console = console;
        this.quantity = quantity;
        this.price = price;
        this.extendedPrice = extendedPrice;
    }

    public Console getConsole() {return console;}

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
        this.extendedPrice = this.price.multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPrice() {return price;}

    public BigDecimal getExtendedPrice() {return extendedPrice;}

    @Override
    public String toString() {
        return String.format("%s | Qty: %d - Price: $%s - Extended: %s",
                console.toString(), quantity, price, extendedPrice);
    }

}
