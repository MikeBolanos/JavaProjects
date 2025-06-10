package com.mycoolcompany.zoomanager.business;

public class Animal {
    private String name; // Name of animal species
    private int populationCount; // Total amount of species in zoo
    private String sound; // Sound the animal makes

    public Animal(String name,int populationCount, String sound) {
        this.name = name;
        this.populationCount = populationCount;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(int populationCount) {
        this.populationCount = populationCount;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

}

