package com.mycoolcompany.zoomanager.business;
// No need to import Animal class, since both files are in the same package

public class Zoo {
    private String name; // Name of the Zoo
    private Animal[] population; // Array of animals in the Zoo

    public Zoo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal[] getPopulation() {
        return population;
    }

    public void setPopulation(Animal[] population) {
        this.population = population;
    }

    // Methods
    // Population Report: Print a header, followed by a list of all animal names and their total population
    public void printPopulationReport() {
        System.out.println("Population Report: " + name);

        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
        System.out.println();
        for (int i = 0; i < population.length; i++) {
            Animal a = population[i];
            System.out.println(a.getName() + ": " + a.getPopulationCount());
        }
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    }
    public void printAnimalSounds() {
            
        }


    // Animal Sounds Report: Print a header, followed by all the sounds we'll hear in the zoo

}
