package com.airport.domain.reservation;

import com.airport.domain.model.*;

import java.util.*;

public class ReservationSystem {
    // Map= (key) Flight number : (value) List of passengers
    private Map<String, List<Passenger>> reservations = new HashMap<>();

    // Add passenger to a flight
    public void addReservation(String flightNumber, Passenger passenger) {

        // If flight doesn't exit, create new passenger list.
        reservations.computeIfAbsent(flightNumber, key -> new ArrayList<>()).add(passenger);
    }

    // Get all passengers on a flight
    public List<Passenger> getPassengersbyFlight(String flightNumber) {
        return reservations.getOrDefault(flightNumber, new ArrayList<>());

    }

    // Return all reservations
    public Map<String, List<Passenger>> getAllReservations() {
        return reservations;
    }

}
