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

import com.nttdata.person.dto.mapper.PersonIdsMapper;
import com.nttdata.person.dto.response.PersonIdsResponse;
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
	private final PersonIdsMapper personIdsMapper;
	
	/**
	 * @param id
	 * @return
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
    public Flux<PersonIdsResponse> getPersonIdsByPersonId(@PathVariable(name="id") String id){
    	return personIdsMapper.toFluxResponse(personIdsService.getPersonIdsByPersonId(id));
    }
    
    /**
     * @param id
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
	@GetMapping("findPersonTypeId/{id}")
    public Flux<PersonIdsResponse> getPersonIdsByPersonTypeId(@PathVariable(name="id") String id){
    	return personIdsMapper.toFluxResponse(personIdsService.getPersonIdsByPersonTypeId(id));
    }
    
    /**
     * @param personIds
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PersonIdsResponse> addPersonIds(@RequestBody Person_Ids personIds){
    	return personIdsMapper.toMonoResponse(personIdsService.addPersonIds(personIds));
    }
    
    /**
     * @param id
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
   	@GetMapping("findPersonId/{id}")
    public Mono<PersonIdsResponse> getPersonIdsById(@PathVariable(name="id")  String id){
    	return personIdsMapper.toMonoResponse(personIdsService.getPersonIdsById(id));
    }
    /**
     * @param personIds
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PersonIdsResponse> setUpdatePersonIds(@RequestBody Person_Ids personIds){
    	return personIdsMapper.toMonoResponse(personIdsService.setUpdatePersonIds(personIds));
    }    
    
    /**
     * @param id
     * @return
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deletePersonIds(@PathVariable(name="id")  String id){
    	return personIdsService.deletePersonIds(id);
    }
}
