package com.airport;

import com.airport.domain.reservation.ReservationSystem;
import com.airport.domain.model.Passenger;
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
        reservationSystem.addReservation("AA101",passenger);

        // Assert that the reservation was added correctly
        List<Passenger> passengers = reservationSystem.getPassengersbyFlight("AA101");

        // Check if passenger is in the list
        assertEquals(1, passengers.size(), "Should only be 1 passenger in the list");
        assertEquals("Alice", passengers.get(0).getName(), "Passenger name should be Alice");
        assertEquals("P12345", passengers.get(0).getPassportNumber(), "Passport number should match"
        );

    }
}
