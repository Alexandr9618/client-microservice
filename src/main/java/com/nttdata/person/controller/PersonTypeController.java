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

import com.nttdata.person.dto.mapper.PersonTypeMapper;
import com.nttdata.person.dto.response.PersonTypeResponse;
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
	private final PersonTypeMapper personTypeMapper;
	
	@ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Flux<PersonTypeResponse> getAllPersonType(){
    	return personTypeMapper.toFluxResponse(personTypeService.getAllPersonType());
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PersonTypeResponse> addPersonType(@RequestBody Person_Type personType){
    	return personTypeMapper.toMonoResponse(personTypeService.addPersonType(personType));
    }
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<PersonTypeResponse> getPersonTypeById(@PathVariable(name="id")  String id){
    	return personTypeMapper.toMonoResponse(personTypeService.getPersonTypeById(id));
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PersonTypeResponse> setUpdatePersonTypeById(@RequestBody Person_Type personType){
    	return personTypeMapper.toMonoResponse(personTypeService.setUpdatePersonTypeById(personType));
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deletePersonType(@PathVariable(name="id")  String id){
    	return personTypeService.deletePersonType(id);
    }
}
