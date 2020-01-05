package com.example.demojpa.module.system.service;

import com.example.demojpa.module.system.entity.Person;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface PersonService {

    Map<String, Object> findAll(Person person, Pageable pageable);
}
