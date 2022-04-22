package com.nttdata.person.service.impl;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nttdata.person.dto.PersonCreateDTO;
import com.nttdata.person.dto.PersonSupplierDTO;
import com.nttdata.person.mapper.IPersonSupplierMapperService;
import com.nttdata.person.model.Person;
import com.nttdata.person.repository.IPersonRepository;
import com.nttdata.person.service.IPersonService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements IPersonService{

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	private final IPersonRepository personRepository;
	private final IPersonSupplierMapperService personSupplierMapperService;

	@Override
	public Mono<Person> addPerson(PersonCreateDTO personCreateDTO) {
		// TODO Auto-generated method stub
		Calendar calendar=Calendar.getInstance();
		PersonSupplierDTO personSupplierDTO=new PersonSupplierDTO(null,personCreateDTO.getFirstName(),personCreateDTO.getLastName(),personCreateDTO.getDocumentType(),
				personCreateDTO.getDocument(),personCreateDTO.getDateNac(),personCreateDTO.getEmail(),personCreateDTO.getIphone(),
				personCreateDTO.getAddress(),calendar.getTime(),null);
		Person person=personSupplierMapperService.convertPersonSupplierDTOToPerson(personSupplierDTO);
		return personRepository.save(person)
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][addPerson]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request" + e));
                }).switchIfEmpty(
                        Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST))
                );
	}

	@Override
	public Mono<Person> getPersonById(String personId) {
		// TODO Auto-generated method stub
		return personRepository.findById(personId)
				.onErrorResume(e -> {
            LOGGER.error("[" + getClass().getName() + "][getPersonById]" + e);
            return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "" + e));
        });
	}

	@Override
	public Mono<Person> setUpdatePerson(Person person) {
		// TODO Auto-generated method stub
		return personRepository.findById(person.getPersonId()).flatMap(p->{
			p.setEmail(person.getEmail());
			p.setIphone(person.getIphone());
			p.setAddress(person.getAddress());
			p.setUpdatedAt(person.getUpdatedAt());
			return personRepository.save(p);
		}).onErrorResume(e -> {
            LOGGER.error("[" + getClass().getName() + "][setUpdatePerson]" + e);
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
        }).switchIfEmpty(
                Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND))
        );
	}

	@Override
	public Mono<Void> deletePerson(String id) {
		// TODO Auto-generated method stub
		return personRepository.deleteById(id)
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][deletePerson]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                });
	}

	@Override
	public Flux<Person> getAllPerson() {
		// TODO Auto-generated method stub
		return personRepository.findAll()
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][getAllPerson]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "" + e));
                });
	}
	

}
