package com.nttdata.person.service;

import com.nttdata.person.model.Person_Type;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IPersonTypeService {

	Mono<Person_Type> addPersonType(Person_Type personType);
	Mono<Person_Type> getPersonTypeById(String id);
	Mono<Person_Type> setUpdatePersonTypeById(Person_Type personType);
	Mono<Void> deletePersonType(String id);
	Flux<Person_Type> getAllPersonType();
}
