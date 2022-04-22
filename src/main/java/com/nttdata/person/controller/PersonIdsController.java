package com.nttdata.person.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.person.model.Person_Ids;
import com.nttdata.person.service.IPersonIdsService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/person-ids")
public class PersonIdsController {

	private final IPersonIdsService personIdsService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
    public Flux<Person_Ids> getPersonIdsByPersonId(@PathVariable(name="id") String id){
    	return personIdsService.getPersonIdsByPersonId(id);
    }
    
    @ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
    public Flux<Person_Ids> getPersonIdsByPersonTypeId(@PathVariable(name="id") String id){
    	return personIdsService.getPersonIdsByPersonTypeId(id);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Person_Ids> addPersonIds(@RequestBody Person_Ids personIds){
    	return personIdsService.addPersonIds(personIds);
    }
    
    @ResponseStatus(HttpStatus.OK)
   	@GetMapping("/{id}")
    public Mono<Person_Ids> getPersonIdsById(@PathVariable(name="id")  String id){
    	return personIdsService.getPersonIdsById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Person_Ids> setUpdatePersonIds(@RequestBody Person_Ids personIds){
    	return personIdsService.setUpdatePersonIds(personIds);
    }    
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deletePersonIds(@PathVariable(name="id")  String id){
    	return personIdsService.deletePersonIds(id);
    }
}
