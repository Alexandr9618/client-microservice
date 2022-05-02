package com.nttdata.person.controller;

import com.nttdata.person.dto.request.ClientRequest;
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
import com.nttdata.person.dto.mapper.ClientMapper;
import com.nttdata.person.dto.response.ClientResponse;
import com.nttdata.person.service.IClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientRestController {

    private final IClientService clientService;

    private final ClientMapper clientMapper;

    public ClientRestController(IClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Flux<ClientResponse> getAllPerson() {
        return clientMapper.toFluxResponse(clientService.getAllPerson());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/create")
    public Mono<ClientResponse> addPerson(@Valid @RequestBody ClientRequest request) {
        System.out.println("create:"  + request);
        return clientMapper.toMonoResponse(clientService.addPerson(request));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ClientResponse> setUpdatePerson(@PathVariable(value = "id") String id,
                                                @RequestBody ClientRequest request) {
        return clientMapper.toMonoResponse(clientService.setUpdatePerson(id, request));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<ClientResponse> getPersonById(@PathVariable(name = "id") String id) {
        System.out.println("byId:"  +id);
        return clientMapper.toMonoResponse(clientService.getPersonById(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deletePerson(@PathVariable(name = "id") String id) {
        return clientService.deletePerson(id);
    }
}
