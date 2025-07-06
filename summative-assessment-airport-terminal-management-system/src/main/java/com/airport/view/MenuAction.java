package com.airport.view;

import java.awt.*;

public enum MenuAction {

    VIEW_FLIGHTS,
    ADD_PASSENGER,
    VIEW_PASSENGERS,
    SAVE_AND_EXIT,
    INVALID;

    public static MenuAction fromInput(String input) {
        return switch (input.trim()) {
            case "1" -> VIEW_FLIGHTS;
            case "2" -> ADD_PASSENGER;
            case "3" -> VIEW_PASSENGERS;
            case "4" -> SAVE_AND_EXIT;
            default -> INVALID;
        };
    }
}
