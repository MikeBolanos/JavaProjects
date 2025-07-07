package com.airport.data;

import com.airport.domain.model.*;

import java.io.*;
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
                LocalDate departureDate = LocalDate.parse(parts[1]);
                BigDecimal ticketPrice = new BigDecimal(parts[2]);
                String passengerName = parts[3];
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

                Flight flight = new Flight(flightNumber, departureDate, ticketPrice, aircraft);

                // Checking to see if passenger is "None" before creating passenger object.
                if (!passengerName.equals("None")) {
                    Passenger passenger = new Passenger(passengerName, passportNumber);

                    // Add passenger to HashMap with flightNumber as key
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

    // Save reservations from HashMap to CSV
    public static void saveReservationsToCSV(String filename,
                                      Map<String, List<Passenger>> reservations,
                                      Map<String, Flight> flightDetails) {
                                    // ^^^ Added HashMap for flight details not included in reservations HashMap.
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            // For each flight number in reservations Map, get list of passengers.
            for (String flightNumber : reservations.keySet()) {
                List<Passenger> passengers = reservations.get(flightNumber);
                Flight flight = flightDetails.get(flightNumber);

                if (flight == null) continue;

                // For each passenger in the list:
                for (Passenger passenger : passengers) {
                    String date = flight.getDepartureDate().toString();
                    String price = flight.getTicketPrice().toString();
                    String name = passenger.getName();
                    String passport = passenger.getPassportNumber();
                    String model = flight.getAircraft().getModel();
                    String type;
                    if (flight.getAircraft() instanceof CommercialAircraft) {
                        type = "Commercial";
                    } else {
                        type = "PrivateJet";

                    writer.println(String.join(",",
                            flightNumber,
                            date,
                            price,
                            name,
                            passport,
                            model,
                            type));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to CSV: " + e.getMessage());
        }
    }
}
