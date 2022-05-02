package com.nttdata.person.controller;

import com.nttdata.person.dto.mapper.PlanMapper;
import com.nttdata.person.dto.request.PlanRequest;
import com.nttdata.person.dto.response.PlanResponse;
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

import com.nttdata.person.service.IPlanService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/plans")
public class PlanController {

    private final IPlanService planService;
    private final PlanMapper planMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Flux<PlanResponse> getAllPersonType() {
        return planMapper.toFluxResponse(planService.getAllPersonType());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PlanResponse> addPersonType(@RequestBody PlanRequest request) {
        return planMapper.toMonoResponse(planService.addPersonType(request));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<PlanResponse> getPersonTypeById(@PathVariable(name = "id") String id) {
        return planMapper.toMonoResponse(planService.getPersonTypeById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PlanResponse> setUpdatePersonTypeById(@PathVariable(value = "id") String id,
                                                      @RequestBody PlanRequest request) {
        return planMapper.toMonoResponse(planService.setUpdatePersonTypeById(id, request));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deletePersonType(@PathVariable(name = "id") String id) {
        return planService.deletePersonType(id);
    }
}
