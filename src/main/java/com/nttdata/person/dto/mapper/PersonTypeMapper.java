package com.nttdata.person.dto.mapper;

import com.nttdata.person.dto.request.PersonTypeRequest;
import com.nttdata.person.dto.response.PersonTypeResponse;
import com.nttdata.person.model.Person_Type;
import com.nttdata.person.util.AppUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * @author Alexander Valerio
 *
 */
@Service
public class PersonTypeMapper {

	/**
	 * @param request
	 * @return
	 */
	public Mono<Person_Type> toPostModel(PersonTypeRequest request){
		return Mono.just(new Person_Type(request.getPersonTypeId(), request.getName(), AppUtil.dateFormat(new Date()),AppUtil.dateFormat(new Date())));
	}
	
	/**
	 * @param personType
	 * @param request
	 * @return
	 */
	public Mono<Person_Type> toPutModel(Person_Type personType,PersonTypeRequest request){
		personType.setName(request.getName());
		personType.setUpdatedAt(AppUtil.dateFormat(new Date()));
		return Mono.just(personType);
	}
	
	/**
	 * @param personType
	 * @return
	 */
	public Mono<PersonTypeResponse> toMonoResponse(Mono<Person_Type> personType){
		return personType.flatMap(p->Mono.just(new PersonTypeResponse(p.getPersonTypeId(), p.getName(), p.getCreatedAt(), p.getUpdatedAt())));
	}
	
	/**
	 * @param personTypes
	 * @return
	 */
	public Flux<PersonTypeResponse> toFluxResponse(Flux<Person_Type> personTypes){
		return personTypes.flatMap(p->toMonoResponse(Mono.just(p)));
	}
}
