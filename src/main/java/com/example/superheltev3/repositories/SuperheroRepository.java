package com.example.superheltev3.repositories;

import com.example.superheltev3.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository {
    private final ArrayList<Superhero> superheroes = new ArrayList<>(List.of(
            new Superhero("Batman","Bruce","Money",129),
            new Superhero("Superman", "Clark","Everyting",1000)
    ));


    public Superhero addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
        return superhero;
    }

    public ArrayList<Superhero> superheroes(){
        return superheroes;
    }

    public Superhero getSuperhero(String name){
        for (Superhero superhero: superheroes) {
            if (superhero.getHeroName().contains(name)){
                return superhero;
            }

        }
        return null;
    }

    public Superhero deleteSuperhero(String name) {
        Superhero superhero1 = getSuperhero(name);
        int index = superheroes.indexOf(superhero1);
        superheroes.remove(index);

        return superhero1;
    }

    public Superhero editHero(Superhero superhero) {
        int coutner = 0;

        for (Superhero hero : superheroes) {
            if(superhero.getHeroName().contains(hero.getHeroName())){
                superheroes.set(coutner,superhero);
                return superhero;
            }
            coutner++;
        }

        return null;
    }

    public String toString() {
        if (superheroes.size() > 0) {
            StringBuilder databaseString = new StringBuilder();
            for (Superhero superhero : superheroes) {
                databaseString.append(superhero.toString());
            }
            return ("\nList of Superheroes: \n-----------------\n" + databaseString);
        } else {
            return "The database is empty.";
        }
    }
}
