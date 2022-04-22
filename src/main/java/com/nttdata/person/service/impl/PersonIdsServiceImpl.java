package com.nttdata.person.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nttdata.person.model.Person_Ids;
import com.nttdata.person.repository.IPersonIdsRepository;
import com.nttdata.person.service.IPersonIdsService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PersonIdsServiceImpl implements IPersonIdsService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonIdsServiceImpl.class);
	private final IPersonIdsRepository personIdsRepository;
	
	public Flux<Person_Ids> getPersonIdsByPersonId(String personId) {
		// TODO Auto-generated method stub
		return personIdsRepository.findAll().filter(item->item.getPersonId().equals(personId))
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][getPersonIdsByPersonId]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                }).switchIfEmpty(
                        Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND))
                );
	}

	@Override
	public Flux<Person_Ids> getPersonIdsByPersonTypeId(String personTypeId) {
		// TODO Auto-generated method stub
		return personIdsRepository.findAll().filter(item->item.getPersonTypeId().equals(personTypeId))
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][getPersonIdsByPersonTypeId]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                }).switchIfEmpty(
                        Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND))
                );
	}

	@Override
	public Mono<Person_Ids> addPersonIds(Person_Ids personIds) {
		// TODO Auto-generated method stub
		return personIdsRepository.save(personIds)
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][addPersonIds]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request" + e));
                }).switchIfEmpty(
                        Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST))
                );
	}

	@Override
	public Mono<Person_Ids> getPersonIdsById(String id) {
		// TODO Auto-generated method stub
		return personIdsRepository.findById(id)
				.onErrorResume(e -> {
		            LOGGER.error("[" + getClass().getName() + "][getPersonIdsById]" + e);
		            return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "" + e));
		        });
	}

	@Override
	public Mono<Person_Ids> setUpdatePersonIds(Person_Ids personIds) {
		// TODO Auto-generated method stub
		return personIdsRepository.findById(personIds.getPersonIdsId()).flatMap(p->{			
			p.setPersonTypeId(personIds.getPersonTypeId());
			p.setPersonId(personIds.getPersonId());
			return personIdsRepository.save(p);
		}).onErrorResume(e -> {
            LOGGER.error("[" + getClass().getName() + "][setUpdatePersonIds]" + e);
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
        }).switchIfEmpty(
                Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND))
        );
	}

	@Override
	public Mono<Void> deletePersonIds(String id) {
		// TODO Auto-generated method stub
		return personIdsRepository.deleteById(id)
				.onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][deletePersonIds]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                });
	}

}
