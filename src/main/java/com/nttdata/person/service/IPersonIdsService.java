package com.nttdata.person.service;

import com.nttdata.person.model.Person_Ids;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonIdsService {

	Flux<Person_Ids> getPersonIdsByPersonId(String personId);
	
	Flux<Person_Ids> getPersonIdsByPersonTypeId(String personTypeId);
	
	Mono<Person_Ids> addPersonIds(Person_Ids personIds);
	
	Mono<Person_Ids> getPersonIdsById(String id);
	
	Mono<Person_Ids> setUpdatePersonIds(Person_Ids personIds);
	
	Mono<Void> deletePersonIds(String id);
}
