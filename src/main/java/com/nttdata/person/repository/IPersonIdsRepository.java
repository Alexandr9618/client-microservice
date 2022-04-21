package com.nttdata.person.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.nttdata.person.model.Person_Ids;

@Repository
public interface IPersonIdsRepository extends ReactiveMongoRepository<Person_Ids, String>{

}
