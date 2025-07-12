package com.classicbit.inventory.model;

public record Console(String id, String name, String manufacturer, String releaseYear, String regionLock) {

    @Override
    public String toString() {
        return String.format("%s: made by %s [%s]. Condition: %s",
                name,
                manufacturer,
                releaseYear,
                regionLock);
    }

}
