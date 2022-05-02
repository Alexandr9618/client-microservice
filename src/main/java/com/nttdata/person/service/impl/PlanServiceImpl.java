package com.nttdata.person.service.impl;

import com.nttdata.person.dto.mapper.PlanMapper;
import com.nttdata.person.dto.request.PlanRequest;
import com.nttdata.person.model.Plan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nttdata.person.repository.IPlanRepository;
import com.nttdata.person.service.IPlanService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PlanServiceImpl implements IPlanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlanServiceImpl.class);
    private final IPlanRepository planRepository;

    private final PlanMapper planMapper;

    @Override
    public Flux<Plan> getAllPersonType() {
        // TODO Auto-generated method stub
        return planRepository.findAll()
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][getAllPersonType]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "" + e));
                });
    }

    @Override
    public Mono<Plan> addPersonType(PlanRequest request) {

        return planMapper.toPostModel(request)
                .flatMap(planRepository::save)
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][addPersonType]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request" + e));
                }).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST)));
    }

    @Override
    public Mono<Plan> getPersonTypeById(String id) {
        return planRepository.findById(id)
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][getPersonTypeById]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "" + e));
                });
    }

    @Override
    public Mono<Plan> setUpdatePersonTypeById(String id, PlanRequest request) {
        // TODO Auto-generated method stub
        return planRepository.findById(id)
                .flatMap(p -> planMapper.toPutModel(p, request)
                        .flatMap(planRepository::save))
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][setUpdatePersonTypeById]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                }).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public Mono<Void> deletePersonType(String id) {
        // TODO Auto-generated method stub
        return planRepository.deleteById(id)
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][deletePersonType]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                });
    }

    @Override
    public Mono<Plan> findByName(String name) {
        return planRepository.findByName(name)
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][findByName]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "" + e));
                });
    }

}
