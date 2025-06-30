package com.airport.domain.model;

import com.airport.domain.model.*;
import com.airport.domain.reservation.ReservationSystem;

public class AddPassengerCommand {
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
