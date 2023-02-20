package com.example.superheltev3.model;


public class Superhero {

    private String heroName;
    private String privateName;
    private String superPower;
    private double strength;

    public Superhero(String heroName, String privateName, String superPower, double strength) {
        this.heroName = heroName;
        this.privateName = privateName;
        this.superPower = superPower;
        this.strength = strength;
    }


    //Get method
    public String getHeroName() {
        return heroName;
    }

    public String toString() {
        String printSuperhero;
        if (heroName != null) {
            printSuperhero = String.format("Superhero Name: %s\nPrivate name: %s\nSuperpowers: %s\nCreation year: %s\nSuperhero is human: %s\nStrength: %s\n==============================\n",
                    heroName, privateName, superPower, strength);
        } else {
            printSuperhero = String.format("Private name: %s\nSuperpowers: %s\nCreation year: %s\nSuperhero is human: %s\nStrength: %s\n=============================\n",
                    privateName, superPower, strength);
        }
        return printSuperhero;
    }
}
