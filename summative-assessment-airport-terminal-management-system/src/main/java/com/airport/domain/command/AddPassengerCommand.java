package com.airport.domain.command;

import com.airport.domain.model.Flight;
import com.airport.domain.model.Passenger;
import com.airport.domain.repository.FlightRepository;
import com.airport.domain.reservation.ReservationSystem;
import com.airport.domain.utils.Utils;
import jdk.jshell.execution.Util;

public class AddPassengerCommand implements Command {
    private final ReservationSystem reservationSystem;
    private final FlightRepository flightRepository;

    public AddPassengerCommand(ReservationSystem reservationSystem, FlightRepository flightRepository) {
        this.reservationSystem = reservationSystem;
        this.flightRepository = flightRepository;
    }

    @Override
    public void execute() {
        Utils.print("\nAvailable Flights");
        flightRepository.getFlights().forEach(flight -> {
            Utils.print("Flight: " + flight.getFlightNumber() + " on " + flight.getDepartureDate());
        });

        String flightNumber = Utils.prompt("Enter the flight number you wish to book: ");
        Flight flight = flightRepository.getFlightByNumber(flightNumber);

        if (flight == null) {
            Utils.print("Flight not found.");
            return;
        }

        String name = Utils.prompt("Enter passenger name: ");
        String passport = Utils.prompt("Enter passport number: ");

        Passenger passenger = new Passenger(name, passport);
        reservationSystem.addReservation(flightNumber, passenger);
        Utils.print("Passenger: (" + name + ") added to flight: " + flightNumber);
    }
}
