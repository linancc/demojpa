package com.example.demojpa.module.system.controller;

import com.example.demojpa.common.utils.PageUtil;
import com.example.demojpa.module.system.entity.Person;
import com.example.demojpa.module.system.service.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Map<String, Object> findAll(Person person, Pageable pageable) {
        return PageUtil.toPage(personService.findAll(person, pageable));
    }
}
