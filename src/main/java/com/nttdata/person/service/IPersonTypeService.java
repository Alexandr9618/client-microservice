package com.nttdata.person.service;

import com.nttdata.person.dto.request.PersonTypeRequest;
import com.nttdata.person.model.PersonType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IPersonTypeService {

	Mono<PersonType> addPersonType(PersonTypeRequest request);
	Mono<PersonType> getPersonTypeById(String id);
	Mono<PersonType> setUpdatePersonTypeById(String id, PersonTypeRequest request);
	Mono<Void> deletePersonType(String id);
	Mono<PersonType> findByName(String name);
	Flux<PersonType> getAllPersonType();
}
