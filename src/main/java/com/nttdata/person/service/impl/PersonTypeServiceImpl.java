package com.nttdata.person.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nttdata.person.model.Person_Type;
import com.nttdata.person.repository.IPersonTypeRepository;
import com.nttdata.person.service.IPersonTypeService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PersonTypeServiceImpl implements IPersonTypeService{

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonTypeServiceImpl.class);
	private final IPersonTypeRepository personTypeRepository;
	
	@Override
	public Flux<Person_Type> getAllPersonType() {
		// TODO Auto-generated method stub
		return personTypeRepository.findAll()
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][getAllPersonType]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "" + e));
                });
	}

	@Override
	public Mono<Person_Type> addPersonType(Person_Type personType) {
		// TODO Auto-generated method stub
		return personTypeRepository.save(personType)
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][addPersonType]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request" + e));
                }).switchIfEmpty(
                        Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST))
                );
	}

	@Override
	public Mono<Person_Type> getPersonTypeById(String id) {
		// TODO Auto-generated method stub
		return personTypeRepository.findById(id)
				.onErrorResume(e -> {
		            LOGGER.error("[" + getClass().getName() + "][getPersonTypeById]" + e);
		            return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "" + e));
		        });
	}

	@Override
	public Mono<Person_Type> setUpdatePersonTypeById(Person_Type personType) {
		// TODO Auto-generated method stub
		return personTypeRepository.findById(personType.getPersonTypeId()).flatMap(p->{
			p.setName(personType.getName());
			p.setUpdatedAt(personType.getUpdatedAt());
			return personTypeRepository.save(p);
		}).onErrorResume(e -> {
            LOGGER.error("[" + getClass().getName() + "][setUpdatePersonTypeById]" + e);
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
        }).switchIfEmpty(
                Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND))
        );
	}

	@Override
	public Mono<Void> deletePersonType(String id) {
		// TODO Auto-generated method stub
		return personTypeRepository.deleteById(id)
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][deletePersonType]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                });
	}

}
