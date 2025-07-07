package com.airport.view;

import com.airport.data.CSVUtil;
import com.airport.domain.model.Flight;
import com.airport.domain.model.Passenger;
import com.airport.domain.repository.FlightRepository;
import com.airport.domain.reservation.ReservationSystem;
import com.airport.domain.utils.Utils;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuHandler {
    private final FlightRepository flightRepository;
    private final ReservationSystem reservationSystem;
    private final String csvFilename;

    // Store flights into ArrayList to select by index
    private final List<Flight> flightList = new ArrayList<>();

    public MenuHandler(FlightRepository flightRepository,
                       ReservationSystem reservationSystem,
                       String csvFilename) {
        this.flightRepository = flightRepository;
        this.reservationSystem = reservationSystem;
        this.csvFilename = csvFilename;

    }
    public void handle(MenuAction action) {
        switch (action) {

            case VIEW_FLIGHTS -> {
                Collection<Flight> flights = flightRepository.getFlights();

                if (flights.isEmpty()) {
                    System.out.println("No flights available");
                }

                Utils.print("\n~*~*~*~ Available Flights ~*~*~*~");

                // AtomicInteger counts, can be used to number flights in output.
                AtomicInteger counter = new AtomicInteger(1);
                flights.stream()
                        .map(flight -> counter.getAndIncrement() + ". " + flight.summary())
                        .forEach(System.out::println);


            }
            case ADD_PASSENGER -> {
                // Clear the flight list and fill from the repository
                flightList.clear();
                Collection<Flight> flights = flightRepository.getFlights();
                flightList.addAll(flights);

                if (flightList.isEmpty()) {
                    Utils.print("No flights available to book");
                }

                Utils.print("Choose a flight to add a passenger: ");
                for (int i = 0; i < flightList.size(); i++) {
                    Utils.print((i+1) + ". " + flightList.get(i).summary());
                }

                int choice = Utils.promptInt("Enter your choice(1 to " + flightList.size() + "): ");
                if (choice < 1 || choice > flightList.size()) {
                    Utils.print("Invalid selection");
                }

                Flight selectedFlight = flightList.get(choice - 1);

                String name = Utils.prompt("Enter the passenger's name: ");
                String passport = Utils.prompt("Enter passport number: ");
                Passenger passenger = new Passenger(name, passport);
                reservationSystem.addReservation(selectedFlight, passenger);

                Utils.print("Passenger: " + name + " added to flight: " + selectedFlight.getFlightNumber());
            }
            case SAVE_RESERVATIONS -> {
                CSVUtil.saveReservationsToCSV(
                        csvFilename,
                        reservationSystem.getAllReservations(),
                        reservationSystem.getFlightDetails()
                );
                Utils.print("Reservations saved to CSV file.");
            }
            case LOAD_RESERVATIONS -> {
                Map<String, List<Passenger>> loaded = CSVUtil.loadReservationsFromCSV(csvFilename);

                loaded.forEach((flightNumber, passengerList) ->
                        passengerList.forEach(p ->
                                reservationSystem.addReservation(flightNumber, p)));
                Utils.print("Reservations loaded from CSV file");
            }

            case VIEW_PASSENGERS -> {
                Map<String, List<Passenger>> allPassengers = reservationSystem.getAllReservations();
                if(allPassengers.isEmpty()) {
                    Utils.print("No reservations found.");
                }
                allPassengers.forEach((flightNumber, passengers) -> {
                    Utils.print("\nFlight: " + flightNumber);
                    passengers.stream()
                            .map(p -> "- " + p.getName() + " (Passport: " + p.getPassportNumber() + ")")
                            .forEach(System.out::println);
                });
            }

            case EXIT -> Utils.print("Thank you for using the Airport Terminal App! Goodbye!");
        }
    }
}
