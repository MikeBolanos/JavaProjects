package com.airport.view;

import java.awt.*;

public enum MenuAction {

    // 1. Create instances of Flight, Passenger, Aircraft (Commercial or Private Jet).
    // 2. Create a ReservationSystem object.
    // 3. Add passengers to flights using the ReservationSystem.
    // 4. Save reservations to the CSV file using CSVUtil.
    // 5. Load reservations from the CSV file using CSVUtil.
    // 6. Demonstrate retrieving pass

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
