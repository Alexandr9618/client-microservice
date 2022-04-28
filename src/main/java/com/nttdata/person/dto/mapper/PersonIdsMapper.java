package com.nttdata.person.dto.mapper;

import org.springframework.stereotype.Service;

import com.nttdata.person.dto.request.PersonIdsRequest;
import com.nttdata.person.dto.response.PersonIdsResponse;
import com.nttdata.person.model.Person_Ids;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class convert request and response
 * @author Alexander Valerio
 * @version 1.0
 */
@Service
public class PersonIdsMapper {

	public Mono<Person_Ids> toPostModel(PersonIdsRequest request){
		return Mono.just(new Person_Ids(request.getPersonIdsId(), request.getPersonTypeId(), request.getPersonId()));
	}
	
	public Mono<Person_Ids> toPutModel(Person_Ids personIds,PersonIdsRequest request){
		personIds.setPersonTypeId(request.getPersonTypeId());
		personIds.setPersonId(request.getPersonId());
		return Mono.just(personIds); 
	}
	
	public Mono<PersonIdsResponse> toMonoResponse(Mono<Person_Ids> personIds){
		return personIds.flatMap(p->Mono.just(new PersonIdsResponse(p.getPersonTypeId(), p.getPersonId())));
	}
	
	public Flux<PersonIdsResponse> toFluxResponse(Flux<Person_Ids> personIds){
		return personIds.flatMap(p->toMonoResponse(Mono.just(p)));
	}
}
