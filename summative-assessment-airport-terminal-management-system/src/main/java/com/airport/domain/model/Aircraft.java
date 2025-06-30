package com.airport.domain.model;

public class Aircraft {
    private String aircraftModel;
    private int capacity;
    private double fuelCapacity; // in liters

    public Aircraft(String aircraftModel, int capacity, double fuelCapacity) {
        this.aircraftModel = aircraftModel;
        this.capacity = capacity;
        this.fuelCapacity = fuelCapacity;
    }

    public String getModel() {
        return aircraftModel;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }
}
