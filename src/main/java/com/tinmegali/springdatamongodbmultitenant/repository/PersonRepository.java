package com.tinmegali.springdatamongodbmultitenant.repository;

import com.tinmegali.springdatamongodbmultitenant.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person,String> {

    Person findFirstById(String id);

}
