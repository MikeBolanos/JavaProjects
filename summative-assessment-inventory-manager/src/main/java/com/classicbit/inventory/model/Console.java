package com.classicbit.inventory.model;

public record Console(
        String id,
        String name,
        String manufacturer,
        String releaseYear,
        String regionLock
) implements Product {

    @Override
    public String toString() {
        return String.format("%s: made by %s [%s]. Condition: %s",
                name,
                manufacturer,
                releaseYear,
                regionLock);
    }

    @Override
    public String getId() {
        return id;
    }
}
