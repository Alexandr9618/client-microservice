package com.nttdata.person.service;

import com.nttdata.person.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {

	Mono<Person> addPerson(Person person);
	Mono<Person> getPersonById(String personId);
	Mono<Person> setUpdatePerson(Person person);
	Mono<Void> deletePerson(String id);
	Flux<Person> getAllPerson();
	
}
