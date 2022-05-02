package com.nttdata.person.service;

import com.nttdata.person.dto.request.PlanRequest;
import com.nttdata.person.model.Plan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IPlanService {

	Mono<Plan> addPersonType(PlanRequest request);
	Mono<Plan> getPersonTypeById(String id);
	Mono<Plan> setUpdatePersonTypeById(String id, PlanRequest request);
	Mono<Void> deletePersonType(String id);
	Mono<Plan> findByName(String name);
	Flux<Plan> getAllPersonType();
}
