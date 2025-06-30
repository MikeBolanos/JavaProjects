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
                String passengerName = parts[3];
                String aircraftModel = parts[4];
                String aircraftType = parts[5];


                // Create a Flight object. (Requires Aircraft object)

                Aircraft aircraft;

                if (aircraftType.equalsIgnoreCase("Commercial")) {
                    aircraft = new CommercialAircraft(aircraftModel, 0, 0, "Unknown");
                } else {
                    aircraft = new PrivateJet(aircraftModel, 0, 0, false, 0);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
