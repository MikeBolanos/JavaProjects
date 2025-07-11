package com.airport.domain.reservation;

import com.airport.domain.model.*;

import java.util.*;

public class ReservationSystem {
    // Map = (key) Flight number : (value) List of passengers
    private Map<String, List<Passenger>> reservations = new HashMap<>();

    // Map to store flight details by flight number
    private Map<String, Flight> flightDetails = new HashMap<>();

    // Add passenger to a flight
    public void addReservation(String flightNumber, Passenger passenger) {
        // If flight doesn't exit, create new passenger list.
        reservations.computeIfAbsent(flightNumber, key -> new ArrayList<>()).add(passenger);
    }

    public void addReservation(Flight flight, Passenger passenger) {
        String flightNumber = flight.getFlightNumber();
        reservations.computeIfAbsent(flightNumber, key -> new ArrayList<>()).add(passenger);

        flightDetails.putIfAbsent(flightNumber, flight);
    }


        // Get all passengers on a flight
    public List<Passenger> getPassengersByFlight(String flightNumber) {
        return reservations.getOrDefault(flightNumber, new ArrayList<>());

    }

    // Return all reservations
    public Map<String, List<Passenger>> getAllReservations() {
        return reservations;
    }

    // Get full flight details
    public Map<String, Flight> getFlightDetails() {
        return flightDetails;
    }
}
