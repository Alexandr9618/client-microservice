package com.nttdata.person.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.nttdata.person.model.Client;

@Repository
public interface IClientRepository extends ReactiveMongoRepository<Client, String>{

}
