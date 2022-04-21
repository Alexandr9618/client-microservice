package com.nttdata.person.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.person.model.Person_Type;

@Repository
public interface IPersonTypeRepository extends ReactiveMongoRepository<Person_Type, String>{

}
