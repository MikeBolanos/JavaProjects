package com.airport.domain.command;

import com.airport.domain.model.Flight;
import com.airport.domain.model.Passenger;
import com.airport.domain.repository.FlightRepository;
import com.airport.domain.reservation.ReservationSystem;

public class AddPassengerCommand implements Command {
    private final ReservationSystem reservationSystem;
    private final FlightRepository flightRepository;

    public AddPassengerCommand(ReservationSystem reservationSystem, FlightRepository flightRepository) {
        this.reservationSystem = reservationSystem;
        this.flightRepository = flightRepository;
    }

    @Override
    public void execute() {
        



}
