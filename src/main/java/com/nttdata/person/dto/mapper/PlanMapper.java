package com.nttdata.person.dto.mapper;

import com.nttdata.person.dto.request.PlanRequest;
import com.nttdata.person.dto.response.PlanResponse;
import com.nttdata.person.model.Plan;
import com.nttdata.person.util.AppUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class PlanMapper {

    /**
     * @param request
     * @return
     */
    public Mono<Plan> toPostModel(PlanRequest request) {
        return Mono.just(new Plan(request.getName(),
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
    public Mono<Plan> toPutModel(Plan person, PlanRequest request) {
        person.setName(request.getName());
        person.setUpdatedAt(AppUtil.dateFormat(new Date()));
        return Mono.just(person);
    }

    /**
     * @param person
     * @return
     */
    public Mono<PlanResponse> toMonoResponse(Mono<Plan> person) {
        return person.flatMap(p -> Mono.just(
                new PlanResponse(p.getId(), p.getName(), p.getCreditQuantity(),
                        p.getCreatedAt(), p.getUpdatedAt()))
        );
    }

    /**
     * @param persons
     * @return
     */
    public Flux<PlanResponse> toFluxResponse(Flux<Plan> persons) {
        return persons.flatMap(p -> toMonoResponse(Mono.just(p)));
    }

}
