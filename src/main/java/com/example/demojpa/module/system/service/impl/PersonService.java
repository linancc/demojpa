package com.example.demojpa.module.system.service.impl;

import com.example.demojpa.common.utils.PageUtil;
import com.example.demojpa.module.system.entity.Person;
import com.example.demojpa.module.system.repository.PersonRepository;
import com.example.demojpa.module.system.service.mapper.PersonMapper;
import com.github.wenhao.jpa.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
public class PersonService implements com.example.demojpa.module.system.service.PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Map<String, Object> findAll(Person person, Pageable pageable) {
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("name", match -> match.contains())
//                .withMatcher("company", match -> match.contains());
//        Example<Person> example = Example.of(person, matcher);
//
//        return personRepository.findAll(example, pageable);

        Specification<Person> spec = Specifications.<Person>and()
                .like(!StringUtils.isEmpty(person.getName()), "name", "%" + person.getName() + "%")
                .like(!StringUtils.isEmpty(person.getCompany()), "company", "%" + person.getCompany() + "%")
                .build();

        Page<Person> page = personRepository.findAll(spec, pageable);
        return PageUtil.toPage(page.map(personMapper::toDto));
    }
}
