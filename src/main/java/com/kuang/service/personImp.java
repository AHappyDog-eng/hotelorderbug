package com.kuang.service;

import com.kuang.entity.Indent;
import com.kuang.entity.Person;
import com.kuang.mapper.personMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class personImp implements person {

    @Autowired
    private com.kuang.mapper.personMapper personMapper;
    @Override
    public List<Person> getAll() {
        List<Person> all = personMapper.getAll();
        return all;
    }

    @Override
    public Person selectPersonById(String personid) {
        Person person = personMapper.selectPersonById(personid);
        return person;
    }

    @Override
    public int addPerson(Person person) {
        int i = personMapper.addPerson(person);
        return i;
    }

    @Override
    public int updatePerson(Person person) {
        int i = personMapper.updatePerson(person);
        return i;
    }

    @Override
    public int deletePerson(String personid) {
        int i = personMapper.deletePerson(personid);
        return i;
    }

    @Override
    public List<Person> seleteByclass(String personjob) {
        List<Person> people = personMapper.seleteByclass(personjob);
        return people;
    }

    @Override
    public List<Person> seleteClass() {
        List<Person> strings = personMapper.seleteClass();
        return strings;
    }
}
