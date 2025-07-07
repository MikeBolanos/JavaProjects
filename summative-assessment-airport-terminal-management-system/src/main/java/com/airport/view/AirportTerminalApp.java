package com.airport.view;


import com.airport.data.CSVUtil;
import com.airport.data.repository.SampleFlightRepository;
import com.airport.domain.repository.FlightRepository;
import com.airport.domain.reservation.ReservationSystem;
import com.airport.domain.utils.Utils;

public class AirportTerminalApp {
    public static void main(String[] args) {
        FlightRepository flightRepository = new SampleFlightRepository();
        ReservationSystem reservationSystem = new ReservationSystem();
        String csvFilename = "src/main/data/reservations.csv";
        CSVUtil.clearCSVFile(csvFilename);

        MenuHandler menuHandler = new MenuHandler(flightRepository, reservationSystem, csvFilename);

        boolean looping = true;

        while (looping) {
            Utils.print("\n~*~*~*~ Airport Menu ~*~*~*~");
            for (MenuAction action : MenuAction.values()) {
                Utils.print((action.ordinal() + 1) + ". " + formatMenuOption(action));
            }

            int choice = Utils.promptInt("\nChoose an option (1 - 6)");
            if (choice < 1 || choice > MenuAction.values().length) {
                Utils.print("Invalid option. Please try again");
                continue;
            }

            MenuAction selectedAction = MenuAction.values()[choice - 1];
            menuHandler.handle(selectedAction);

            if(selectedAction == MenuAction.EXIT) {
                looping = false;
            }
        }
    }
    public static String formatMenuOption(MenuAction action) {
        return switch (action) {
            case VIEW_FLIGHTS -> "View Available Flights";
            case ADD_PASSENGER -> "Add Passenger to FLight";
            case SAVE_RESERVATIONS -> "Save Reservations to CSV";
            case LOAD_RESERVATIONS -> "Load Reservations from CSV";
            case VIEW_PASSENGERS -> "View Passengers by FLight";
            case EXIT -> "Exit Application";
        };
    }
}
