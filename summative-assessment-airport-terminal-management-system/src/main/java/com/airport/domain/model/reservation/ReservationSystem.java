package com.airport.domain.model.reservation;

import com.airport.domain.model.*;

import java.util.*;

public class ReservationSystem {
    // Map= (key) Flight number : (value) List of passengers
    private Map<String, List<Passenger>> reservations = new HashMap<>();

    // Add passenger to a flight
    public void addReservation(Flight flight, Passenger passenger) {
        String flightNumber = flight.getFlightNumber();

        // If flight doesn't exit, create new passenger list.
        if(!reservations.containsKey(flightNumber)) {
            reservations.put(flightNumber, new ArrayList<>());
        }
        reservations.get(flightNumber).add(passenger);
    }

    // Get all passengers on a flight
    public List<Passenger> getPassengersbyFlight(String flightNumber) {
        return reservations.getOrDefault(flightNumber, Collections.emptyList());
    }


}
