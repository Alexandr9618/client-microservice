package com.nttdata.person.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.nttdata.person.model.Person;
import com.nttdata.person.service.IPersonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/api/v1/person")
public class PersonRestController {

	private IPersonService personService;

	public PersonRestController(IPersonService personService) {
		this.personService=personService;
	}
	
	@ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Flux<Person> getAllPerson(){
		return personService.getAllPerson();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,path = "/create")
	public Mono<Person> addPerson(@Valid @RequestBody Person person){
		return personService.addPerson(person);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Person> setUpdatePerson(@RequestBody Person person){
		return personService.setUpdatePerson(person);
	}
	
	@ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<Person> getPersonById(@PathVariable(name="id") String id){
		return personService.getPersonById(id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
	public Mono<Void> deletePerson(@PathVariable(name="id") String id){
		return personService.deletePerson(id);
	}
}
