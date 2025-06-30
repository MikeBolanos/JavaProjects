package com.skylinetech.model;

public class PrivateJet extends Aircraft {
    private boolean hasLuxuryService;
    private int maxSpeed; // in km/hr


    public PrivateJet(String model, int capacity, double fuelCapacity, boolean hasLuxuryService, int maxSpeed) {
        super(model, capacity, fuelCapacity);
        this.hasLuxuryService = hasLuxuryService;
        this.maxSpeed = maxSpeed;
    }

    public boolean isHasLuxuryService() {
        return hasLuxuryService;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
