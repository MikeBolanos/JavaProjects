package com.shoppinginc.models;

public class Item {
    // fields
    private final String name;
    private final double price;

    // Constructor
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters/Setters

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //Override toString to print item details
    public String toString() {
        return String.format("%-20s$%.2f", name, price);
    }
}
