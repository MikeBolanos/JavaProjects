package com.classicbit.inventory.model;

public record RareConsole(
        Console baseConsole,
        String rarity,
        String certificate
) implements Product {

    @Override
    public String toString() {
        return baseConsole.toString() + String.format(
                " | Rarity: %s | Certificate: %s",
                rarity, certificate);
    }

    @Override
    public String getId() {
        return baseConsole.getId();
    }

    public Console getBaseConsole() {
        return baseConsole;
    }
}
