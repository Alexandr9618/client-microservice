package com.nttdata.person.dto.mapper;

import org.springframework.stereotype.Service;

import com.nttdata.person.model.Person_Ids;

import reactor.core.publisher.Mono;

/**
 * This class convert request and response
 * @author Alexander Valerio
 * @version 1.0
 */
@Service
public class PersonIdsMapper {

	public Mono<Person_Ids> toPostModel(){
		return null;
	}
}
