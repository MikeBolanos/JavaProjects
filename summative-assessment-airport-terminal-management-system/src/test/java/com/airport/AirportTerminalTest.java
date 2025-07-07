package com.airport;

import com.airport.domain.model.Flight;
import com.airport.domain.reservation.ReservationSystem;
import com.airport.domain.model.Passenger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirportTerminalTest {


    @Test
    public void testAddReservation() {
        // Create Passenger object
        Passenger passenger = new Passenger("Alice", "P12345");

        // Create a ReservationSystem object
        ReservationSystem reservationSystem = new ReservationSystem();

        // Call the addReservation method
        Flight flight = new Flight("AA101", LocalDate.of(2025, 8, 15), new BigDecimal("299.99"), aircraft);
        reservationSystem.addReservation("AA101",passenger);

        // Assert that the reservation was added correctly
        List<Passenger> passengers = reservationSystem.getPassengersByFlight("AA101");

        // Check if passenger is in the list
        assertEquals(1, passengers.size(), "Should only be 1 passenger in the list");
        assertEquals("Alice", passengers.get(0).getName(), "Passenger name should be Alice");
        assertEquals("P12345", passengers.get(0).getPassportNumber(), "Passport number should match");

    }

    @Test
    public void testGetPAssengersForFlight() {

        // Create Passenger objects
        Passenger passenger1 = new Passenger("Alice", "P12345");
        Passenger passenger2 = new Passenger("Bob", "P67890");

        // Create a ReservationSystem object
        ReservationSystem reservationSystem = new ReservationSystem();

        // Add passengers to a flight
        reservationSystem.addReservation("AA101", passenger1);
        reservationSystem.addReservation("AA101", passenger2);

        // Call the getPassengersByFlight method
        List<Passenger> passengers = reservationSystem.getPassengersByFlight("AA101");

        // Assert that the correct list of passengers is returned
        assertEquals(2, passengers.size(), "There should be 2 passengers for flight AA101");
        assertTrue(passengers.stream().anyMatch(passenger -> passenger.getName().equals("Alice")));
        assertTrue(passengers.stream().anyMatch(passenger -> passenger.getName().equals("Bob")));
    }
}
