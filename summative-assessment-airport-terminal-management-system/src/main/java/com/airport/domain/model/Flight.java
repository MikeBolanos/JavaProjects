package com.airport.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Flight {
    private String flightNumber;
    private LocalDate departureDate;
    private BigDecimal ticketPrice;
    private Aircraft aircraft;

    public Flight(String flightNumber, LocalDate departureDate, BigDecimal ticketPrice, Aircraft aircraft) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.ticketPrice = ticketPrice;
        this.aircraft = aircraft;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public String summary() {
        String model = aircraft.getModel();
        String type;
        if (aircraft instanceof CommercialAircraft) {
            type = "Commercial";
        } else {
            type = "Private Jet";
        }

        return String.format(
                "Flight: %s | Date: %s | Price: %s | Aircraft: %s (%s)",
                flightNumber,
                departureDate,
                ticketPrice,
                model,
                type
        );
    }
}
