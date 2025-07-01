package com.airport.data;

import com.airport.domain.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class CSVUtil {

    // Load reservations from CSV and return a HashMap
    public static Map<String, List<Passenger>> loadReservationsFromCSV(String filename) {
        Map<String, List<Passenger>> reservations = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Split each line of data into parts

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length < 7) continue;

                String flightNumber = parts[0];
                LocalDate date = LocalDate.parse(parts[1]);
                BigDecimal price = new BigDecimal(parts[2]);
                String name = parts[3];
                String passportNumber = parts [4];
                String aircraftModel = parts[5];
                String aircraftType = parts[6];


                // Create a Flight object. (Requires Aircraft object)

                Aircraft aircraft;

                if (aircraftType.equalsIgnoreCase("Commercial")) {
                    aircraft = new CommercialAircraft(aircraftModel, 0, 0, "Unknown");
                } else {
                    aircraft = new PrivateJet(aircraftModel, 0, 0, false, 0);
                }

                Flight flight = new Flight(flightNumber, date, price, aircraft);

                // Checking to see if passenger is "None" before creating passenger object.
                if (!name.equals("None")) {
                    Passenger passenger = new Passenger(name, passportNumber);

                    // Add passenger to map with flightNumber as key
                 if (!reservations.containsKey(flightNumber)) {
                    reservations.put(flightNumber, new ArrayList<>());
                }
                reservations.get(flightNumber).add(passenger);
            }
        }

        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        return reservations;
    }

    //Save reservations from Map to CSV
    public void

}
