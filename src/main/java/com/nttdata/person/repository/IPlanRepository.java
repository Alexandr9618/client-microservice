package com.nttdata.person.repository;

import com.nttdata.person.model.Plan;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface IPlanRepository extends ReactiveMongoRepository<Plan, String> {

    Mono<Plan> findByName(String name);

}
