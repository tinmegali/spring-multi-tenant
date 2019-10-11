package com.tinmegali.springdatamongodbmultitenant.service;

import com.tinmegali.springdatamongodbmultitenant.model.Person;
import com.tinmegali.springdatamongodbmultitenant.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Person person)
    {
        personRepository.save(person);
    }

    public Person getPerson(String id)
    {
        return personRepository.findFirstById(id);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }


}
