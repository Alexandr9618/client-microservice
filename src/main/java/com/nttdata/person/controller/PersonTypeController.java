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

import com.nttdata.person.model.Person_Type;
import com.nttdata.person.service.IPersonTypeService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/person-type")
public class PersonTypeController {

	private final IPersonTypeService personTypeService;
	
	@ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Flux<Person_Type> getAllPersonType(){
    	return personTypeService.getAllPersonType();
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Person_Type> addPersonType(@RequestBody Person_Type personType){
    	return personTypeService.addPersonType(personType);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<Person_Type> getPersonTypeById(@PathVariable(name="id")  String id){
    	return personTypeService.getPersonTypeById(id);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Person_Type> setUpdatePersonTypeById(@RequestBody Person_Type personType){
    	return personTypeService.setUpdatePersonTypeById(personType);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deletePersonType(@PathVariable(name="id")  String id){
    	return personTypeService.deletePersonType(id);
    }
}
