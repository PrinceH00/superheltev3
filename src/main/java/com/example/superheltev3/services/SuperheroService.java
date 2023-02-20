package com.example.superheltev3.services;

import com.example.superheltev3.model.Superhero;
import org.springframework.stereotype.Service;
import com.example.superheltev3.repositories.SuperheroRepository;

import java.util.ArrayList;

@Service
public class SuperheroService {

    private SuperheroRepository repository;

    public SuperheroService(SuperheroRepository repository) {
        this.repository = repository;
    }

    public Superhero addSuperhero(Superhero superhero){
        return repository.addSuperhero(superhero);
    }

    public ArrayList<Superhero> superheroes(){
        return repository.superheroes();
    }

    public Superhero getSuperhero(String name){
        return repository.getSuperhero(name);
    }

    public Superhero deleteSuperhero(String name){
        return repository.deleteSuperhero(name);
    }

    public Superhero editSuperhero(Superhero superhero) {
        return repository.editHero(superhero);
    }
}

