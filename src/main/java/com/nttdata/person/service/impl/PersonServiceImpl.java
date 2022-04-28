package com.nttdata.person.service.impl;

import com.nttdata.person.dto.mapper.PersonMapper;
import com.nttdata.person.dto.request.PersonRequest;
import com.nttdata.person.service.IPersonTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.nttdata.person.model.Person;
import com.nttdata.person.model.PersonType;
import com.nttdata.person.repository.IPersonRepository;
import com.nttdata.person.service.IPersonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements IPersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final IPersonRepository personRepository;

    private final PersonMapper personMapper;

    private final IPersonTypeService personTypeService;

    public PersonServiceImpl(IPersonRepository personRepository, PersonMapper personMapper, IPersonTypeService personTypeService) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.personTypeService = personTypeService;
    }

    @Override
    public Mono<Person> addPerson(PersonRequest request) {
        Mono<PersonType> personType = personTypeService.findByName(request.getPersonType().getName());
        Mono<Person> person = personMapper.toPostModel(request);
        return personType.flatMap(pt -> person
                .flatMap(p -> {
                    p.setPersonType(pt);
                    return personRepository.save(p)
                            .onErrorResume(e -> {
                                LOGGER.error("[" + getClass().getName() + "][addPerson]" + e);
                                return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request" + e));
                            }).switchIfEmpty(
                                    Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST))
                            );
                }));
    }

    @Override
    public Mono<Person> getPersonById(String personId) {
        return personRepository.findById(personId)
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][getPersonById]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                }).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public Mono<Person> setUpdatePerson(String id, PersonRequest request) {
        Mono<PersonType> personType = personTypeService.findByName(request.getPersonType().getName());
        return personType.flatMap(pt -> personRepository.findById(id)
                .flatMap(p -> personMapper.toPutModel(p, request)
                        .flatMap(per -> {
                            p.setPersonType(pt);
                            return personRepository.save(p);
                        }))
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][setUpdatePerson]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                }).switchIfEmpty(
                        Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND))
                ));
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
