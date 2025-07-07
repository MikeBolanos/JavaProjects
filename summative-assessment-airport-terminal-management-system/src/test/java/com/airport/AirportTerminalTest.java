package com.airport;

import com.airport.data.CSVUtil;
import com.airport.domain.model.*;
import com.airport.domain.reservation.ReservationSystem;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirportTerminalTest {


    @Test
    public void canAddAReservation() {
        // Create Passenger object
        Passenger passenger = new Passenger("Alice", "P12345");

        // Create a ReservationSystem object
        ReservationSystem reservationSystem = new ReservationSystem();

        // Call the addReservation method
        reservationSystem.addReservation("AA101",passenger);

        // Assert that the reservation was added correctly
        List<Passenger> passengers = reservationSystem.getPassengersByFlight("AA101");

        // Check if passenger is in the list
        assertEquals(1, passengers.size(), "Should only be 1 passenger in the list");
        assertEquals("Alice", passengers.get(0).getName(), "Passenger name should be Alice");
        assertEquals("P12345", passengers.get(0).getPassportNumber(), "Passport number should match");

    }

    @Test
    public void canGetPassengersForFlight() {

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
        assertEquals(2, passengers.size(), "Should be 2 passengers for flight AA101");
        assertTrue(passengers.stream().anyMatch(passenger -> passenger.getName().equals("Alice")));
        assertTrue(passengers.stream().anyMatch(passenger -> passenger.getName().equals("Bob")));
    }

    @Test
    public void canSaveAndLoadReservations() {
        String testFilename = "src/test/resources/reservations.csv";

        Map<String, List<Passenger>> reservations = new HashMap<>();
        Map<String, Flight> flightDetails = new HashMap<>();

        Aircraft aircraft = new PrivateJet("LearJet 75", 9, 1400, false, 870);
        Flight flight = new Flight("PJ001", LocalDate.of(2025, 6, 26), new BigDecimal("4000.00"), aircraft);

        Passenger passenger = new Passenger("Mike", "P56789");

        reservations.put("PJ001", List.of(passenger));
        flightDetails.put("PJ001", flight);

        // Save to CSV
        CSVUtil.saveReservationsToCSV(testFilename, reservations,flightDetails);

        //Load from CSV
        Map<String, List<Passenger>> loaded = CSVUtil.loadReservationsFromCSV(testFilename);

        assertTrue(loaded.containsKey("PJ001"));
        assertEquals(1, loaded.get("PJ001").size());
        assertEquals("Mike", loaded.get("PJ001").get(0).getName());

        //Delete test file for future tests
        new File(testFilename).delete();
    }
}
