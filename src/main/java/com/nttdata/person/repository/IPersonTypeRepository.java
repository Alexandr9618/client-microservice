package com.nttdata.person.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.person.model.PersonType;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface IPersonTypeRepository extends ReactiveMongoRepository<PersonType, String> {

    Mono<PersonType> findByName(String name);

}
