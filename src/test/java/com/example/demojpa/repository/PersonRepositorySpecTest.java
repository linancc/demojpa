package com.example.demojpa.repository;

import com.example.demojpa.module.system.entity.Person;
import com.example.demojpa.module.system.repository.PersonRepository;
import com.github.wenhao.jpa.Specifications;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositorySpecTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void simpleTest() {
        Person person = new Person();
        person.setName("li");

        Specification<Person> spec = (Specification<Person>) (root, query, builder) ->
                builder.like(root.get("name"), "%" + person.getName() + "%");

        List<Person> all = personRepository.findAll(spec);
    }

    @Test
    public void simpleSpecTest() {
        Person person = new Person();
        person.setName("li");

        Specification<Person> spec = Specifications.<Person>and()
                .like(!StringUtils.isEmpty(person.getName()), "name", "%" + person.getName() + "%")
                .like(!StringUtils.isEmpty(person.getCompany()), "company", "%" + person.getCompany() + "%")
                .build();

        List<Person> all = personRepository.findAll(spec);
        all.forEach(System.out::println);
    }
}
