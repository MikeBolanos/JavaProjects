package com.airport.view;

import com.airport.domain.model.Flight;
import com.airport.domain.repository.FlightRepository;
import com.airport.domain.reservation.ReservationSystem;
import com.airport.domain.utils.Utils;

public class MenuHandler {
    public static void handle(
            MenuAction action,
            ReservationSystem reservationSystem,
            FlightRepository flightRepository,
            String csvFilename
    ) {
        switch (action) {

            case VIEW_FLIGHTS -> {
                System.out.println("\nAvailable Flights");
                for (Flight flight : flightRepository.getFlights()) {
                    Utils.print(flight.summary());
                }
            }
        }
    }
}
