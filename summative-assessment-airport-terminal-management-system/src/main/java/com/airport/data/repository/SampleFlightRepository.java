package com.airport.data.repository;

import com.airport.domain.model.Aircraft;
import com.airport.domain.model.CommercialAircraft;
import com.airport.domain.model.Flight;
import com.airport.domain.model.PrivateJet;
import com.airport.domain.repository.FlightRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SampleFlightRepository implements FlightRepository {
    // Storing flights in a map to look up by flight number.
    private final Map<String, Flight> flightMap;

    public SampleFlightRepository() {

        // Commercial Flights
        Aircraft commercial1 = new CommercialAircraft("Embraer 190", 100, 13000, "United Airlines");
        Aircraft commercial2 = new CommercialAircraft("Boeing 737", 180, 26000, "American Airlines");
        Aircraft commercial3 = new CommercialAircraft("Airbus", 160, 24000,"Delta Airlines");

        // Private Jet Flights
        Aircraft private1 = new PrivateJet("LearJet 75", 9, 14000, false, 870);
        Aircraft private2 = new PrivateJet("Glufstream G650", 12, 20000, true, 950);
        Aircraft private3 = new PrivateJet("Cessna Citation X", 8, 15000, true, 990);

        // List of flights
        List<Flight> flights = List.of(
            new Flight("UA303", LocalDate.of(2025, 6, 25), new BigDecimal("310.00"), commercial1),
            new Flight("AA101", LocalDate.of(2025, 6, 28), new BigDecimal("299.99"), commercial2),
            new Flight("DL202", LocalDate.of(2025, 6, 30), new BigDecimal("350.50"), commercial3),
            new Flight("PJ001", LocalDate.of(2025, 6, 26), new BigDecimal("4000.00"), private1),
            new Flight("PJ002", LocalDate.of(2025, 6, 27), new BigDecimal("5000.00"), private2),
            new Flight("PJ003", LocalDate.of(2025, 6, 25), new BigDecimal("4500.00"), private3)
            );

        // Adding flights to the map
        flightMap = flights.stream()
                .collect(Collectors.toMap(
                        Flight::getFlightNumber,
                        flight -> flight
                ));
    }


    @Override
    public Collection<Flight> getFlights() {
        return flightMap.values();
    }

    @Override
    public Flight getFlightByNumber(String flightNumber) {
        return flightMap.get(flightNumber);
    }
}
