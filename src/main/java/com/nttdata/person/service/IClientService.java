package com.nttdata.person.service;

import com.nttdata.person.dto.request.ClientRequest;
import com.nttdata.person.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientService {

	Mono<Client> addPerson(ClientRequest request);
	Mono<Client> getPersonById(String personId);
	Mono<Client> setUpdatePerson(String id, ClientRequest request);
	Mono<Void> deletePerson(String id);
	Flux<Client> getAllPerson();
	
}
