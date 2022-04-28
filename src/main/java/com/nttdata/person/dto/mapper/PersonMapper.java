package com.nttdata.person.dto.mapper;

import java.util.Date;

import com.nttdata.person.dto.response.PersonTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.nttdata.person.dto.request.PersonRequest;
import com.nttdata.person.dto.response.PersonResponse;
import com.nttdata.person.model.Person;
import com.nttdata.person.model.PersonType;
import com.nttdata.person.util.AppUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class convert request and response
 *
 * @author Alexander Valerio
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class PersonMapper {

    private final PersonTypeMapper personTypeMapper;

    /**
     * This method convert request to model
     *
     * @param request request of personRequest
     * @return Person model
     */
    public Mono<Person> toPostModel(PersonRequest request) {
        return Mono.just(new Person(request.getFirstName(),
                        request.getLastName(),
                        request.getDocumentType(),
                        request.getDocument(),
                        request.getBirthDate(),
                        request.getEmail(),
                        request.getIphone(),
                        request.getAddress(),
                        AppUtil.dateFormat(new Date()),
                        AppUtil.dateFormat(new Date())
                )
        );
    }


    /**
     * @param person
     * @param request
     * @return
     */
    public Mono<Person> toPutModel(Person person, PersonRequest request) {
        person.setEmail(request.getEmail());
        person.setIphone(request.getIphone());
        person.setAddress(request.getAddress());
        person.setUpdatedAt(AppUtil.dateFormat(new Date()));
        return Mono.just(person);
    }

    /**
     * @param person
     * @return
     */
    public Mono<PersonResponse> toMonoResponse(Mono<Person> person) {
        return person.flatMap(p -> {
            Mono<PersonTypeResponse> personTypeResponse = personTypeMapper
                    .toMonoResponse(Mono.just(p.getPersonType()));
            return personTypeResponse.flatMap(pt -> Mono.just(
                            new PersonResponse(p.getPersonId(), p.getFirstName(), p.getLastName(),
                                    p.getDocumentType(), p.getDocument(), p.getBirthDate(), p.getEmail(),
                                    p.getIphone(), p.getAddress(), p.getCreatedAt(), p.getUpdatedAt(), pt)
                    )
            );
        });
    }

    /**
     * @param persons
     * @return
     */
    public Flux<PersonResponse> toFluxResponse(Flux<Person> persons) {
        return persons.flatMap(p -> toMonoResponse(Mono.just(p)));
    }
}
