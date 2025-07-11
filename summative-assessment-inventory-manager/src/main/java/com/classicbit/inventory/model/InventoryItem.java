package com.classicbit.inventory.model;

import java.math.BigDecimal;

public class InventoryItem {
    private final Console console;
    private int quantity;
    private BigDecimal price;

    public InventoryItem(Console console, int quantity, BigDecimal price) {
        this.console = console;
        this.quantity = quantity;
        this.price = price;
    }

    public Console getConsole() { return console;}

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s - Stock: %d - Price: $%,2f", console.toString(), quantity, price);
    }
}
