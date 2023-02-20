package com.example.superheltev3.controllers;

import com.example.superheltev3.model.Superhero;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.superheltev3.services.SuperheroService;

import java.util.List;

@RequestMapping(path = "superhero")
@Controller
public class Mycontroller {

    private SuperheroService service;

    public Mycontroller(SuperheroService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Superhero>> getSuperheros(){
        List superheroList = service.superheroes();
        return new ResponseEntity<>(superheroList , HttpStatus.OK);
    }

    @GetMapping(path ="/{name}")
    public ResponseEntity<Superhero> hero(@PathVariable String name){
        return new  ResponseEntity<>(service.getSuperhero(name),HttpStatus.OK);
    }

    @PostMapping(path ="/add")
    public ResponseEntity<Superhero> addhero(@RequestBody Superhero superhero){
        return new  ResponseEntity<>(service.addSuperhero(superhero),HttpStatus.OK);
    }

    @PutMapping(path ="/change")
    public ResponseEntity<Superhero> editSuperhero(@RequestBody Superhero superhero){
        return new ResponseEntity<>(service.editSuperhero(superhero),HttpStatus.OK);
    }

    @DeleteMapping(path ="delete/{name}")
    public ResponseEntity<Superhero> deletehero(@PathVariable String name){
        return new  ResponseEntity<>(service.deleteSuperhero(name),HttpStatus.OK);
    }

    @RequestMapping(path = "/")
    public ResponseEntity<String> format(@RequestParam String format){
        StringBuilder stringBuilder = new StringBuilder();
        List<Superhero> superheroList = service.superheroes();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Content-type", "text/html");

        if (format != null && format.equals("html")){
            stringBuilder.append("<html> <body>").append(superheroList).append("</body></html>");
            return new ResponseEntity<>(stringBuilder.toString(),headers , HttpStatus.OK);
        }

        return null;

    }


}
