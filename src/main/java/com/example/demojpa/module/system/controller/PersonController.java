package com.example.demojpa.module.system.controller;

import com.example.demojpa.module.system.entity.Person;
import com.example.demojpa.module.system.service.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll(Person person, Pageable pageable) {
        return new ResponseEntity<>(personService.findAll(person, pageable), HttpStatus.OK);
    }
}
