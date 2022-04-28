package com.nttdata.person.service;

import com.nttdata.person.dto.request.PersonRequest;
import com.nttdata.person.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {

	Mono<Person> addPerson(PersonRequest request);
	Mono<Person> getPersonById(String personId);
	Mono<Person> setUpdatePerson(String id, PersonRequest request);
	Mono<Void> deletePerson(String id);
	Flux<Person> getAllPerson();
	
}
