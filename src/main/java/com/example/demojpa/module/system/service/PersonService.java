package com.example.demojpa.module.system.service;

import com.example.demojpa.module.system.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

    Page<Person> findAll(Person person, Pageable pageable);
}
