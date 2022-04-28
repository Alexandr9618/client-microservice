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
import com.nttdata.person.dto.mapper.PersonMapper;
import com.nttdata.person.dto.response.PersonResponse;
import com.nttdata.person.model.Person;
import com.nttdata.person.service.IPersonService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/person")
public class PersonRestController {

	private final IPersonService personService;
	
	private final PersonMapper personMapper;

	
	@ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Flux<PersonResponse> getAllPerson(){
		return personMapper.toFluxResponse(personService.getAllPerson());
	}
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,path = "/create")
	public Mono<PersonResponse> addPerson(@RequestBody Person person){
		return personMapper.toMonoResponse(personService.addPerson(person));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<PersonResponse> setUpdatePerson(@RequestBody Person person){
		return personMapper.toMonoResponse(personService.setUpdatePerson(person));
	}
	
	@ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<PersonResponse> getPersonById(@PathVariable(name="id") String id){
		return personMapper.toMonoResponse(personService.getPersonById(id));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
	public Mono<Void> deletePerson(@PathVariable(name="id") String id){
		return personService.deletePerson(id);
	}
}
