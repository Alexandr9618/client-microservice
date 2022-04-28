package com.nttdata.person.dto.mapper;

import com.nttdata.person.dto.request.PersonTypeRequest;
import com.nttdata.person.dto.response.PersonTypeResponse;
import com.nttdata.person.model.PersonType;
import com.nttdata.person.util.AppUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class PersonTypeMapper {

    /**
     * @param request
     * @return
     */
    public Mono<PersonType> toPostModel(PersonTypeRequest request) {
        return Mono.just(new PersonType(request.getName(),
                request.getCreditQuantity(),
                AppUtil.dateFormat(new Date()),
                AppUtil.dateFormat(new Date()))
        );
    }

    /**
     * @param person
     * @param request
     * @return
     */
    public Mono<PersonType> toPutModel(PersonType person, PersonTypeRequest request) {
        person.setName(request.getName());
        person.setUpdatedAt(AppUtil.dateFormat(new Date()));
        return Mono.just(person);
    }

    /**
     * @param person
     * @return
     */
    public Mono<PersonTypeResponse> toMonoResponse(Mono<PersonType> person) {
        return person.flatMap(p -> Mono.just(
                new PersonTypeResponse(p.getId(), p.getName(), p.getCreditQuantity(),
                        p.getCreatedAt(), p.getUpdatedAt()))
        );
    }

    /**
     * @param persons
     * @return
     */
    public Flux<PersonTypeResponse> toFluxResponse(Flux<PersonType> persons) {
        return persons.flatMap(p -> toMonoResponse(Mono.just(p)));
    }

}
