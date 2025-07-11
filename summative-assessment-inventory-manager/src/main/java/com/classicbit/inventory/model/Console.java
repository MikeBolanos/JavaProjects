package com.classicbit.inventory.model;

public record Console(String id, String name, String manufacturer, String releaseYear, String condition) {

    @Override
    public String toString() {
        return String.format("%s: made by %s [%s]. Condition: %s",
                name,
                manufacturer,
                releaseYear,
                condition);
    }

}
