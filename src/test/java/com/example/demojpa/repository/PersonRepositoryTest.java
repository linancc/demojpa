package com.example.demojpa.repository;

import com.example.demojpa.module.system.entity.Person;
import com.example.demojpa.module.system.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void simpleTest() {
        Person person = new Person();
        person.setName("linan");

        Example<Person> example = Example.of(person);

        Optional<Person> one = personRepository.findOne(example);
    }

    @Test
    public void matcherTest() {
        Person person = new Person();
        person.setName("linan");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withIncludeNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

        Example<Person> example = Example.of(person, matcher);

        Optional<Person> one = personRepository.findOne(example);

    }

    @Test
    public void configMatcherTest() {
        Person person = new Person();
        person.setName("linan");
        person.setCompany("海");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", endsWith())
                .withMatcher("company", startsWith().ignoreCase());

        Example<Person> example = Example.of(person, matcher);
        List<Person> all = personRepository.findAll(example);
        all.forEach(x -> System.out.println(x));
    }

    @Test
    public void configMatcherLambdaTest() {
        Person person = new Person();
        person.setName("linan");
        person.setCompany("海");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", match -> match.endsWith())
                .withMatcher("company", match -> match.startsWith().ignoreCase());

        Example<Person> example = Example.of(person, matcher);
        List<Person> all = personRepository.findAll(example);
        all.forEach(System.out::println);
    }
}
