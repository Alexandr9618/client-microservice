package com.nttdata.person.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.nttdata.person.model.Person;

@Repository
public interface IPersonRepository extends ReactiveMongoRepository<Person, String>{

}
