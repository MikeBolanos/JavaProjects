package com.airport.domain.repository;

import com.airport.domain.model.Flight;

import java.util.Collection;

public interface FlightRepository {
    Collection<Flight> getFlights();
    Flight getFlightByNumber(String flightNumber);
}

