package com.google.example.controller;


import com.google.example.entitiy.Person;
import com.google.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {


    @Autowired
    private PersonRepository personRepository;


    @GetMapping
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestParam String name) {
        Person person = new Person();
        person.setName(name);
        return personRepository.save(person);
    }

}
