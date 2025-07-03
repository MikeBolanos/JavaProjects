package com.airport.domain.command;

import com.airport.domain.model.Flight;
import com.airport.domain.model.Passenger;
import com.airport.domain.reservation.ReservationSystem;

public class AddPassengerCommand implements Command {
    private ReservationSystem system;
    private Flight flight;
    private Passenger passenger;

    public AddPassengerCommand(ReservationSystem system, Flight flight, Passenger passenger) {
        this.system = system;
        this.flight = flight;
        this.passenger = passenger;
    }

    @Override
    public void execute() {
        system.addReservation(flight, passenger);
    }



}
