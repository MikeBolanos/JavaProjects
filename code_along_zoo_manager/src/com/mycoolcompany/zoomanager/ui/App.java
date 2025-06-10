package com.mycoolcompany.zoomanager.ui;

import com.mycoolcompany.zoomanager.business.Animal;

import com.mycoolcompany.zoomanager.business.Zoo;

public class App {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Kamala Zoo");

        Animal lion = new Animal("Lion", 6, "Roar");
        Animal tiger = new Animal("Tiger", 4, "Growl");
        Animal bear = new Animal("Bear", 2, "Snarl");

        Animal[] population = new Animal[3];
    }
}
