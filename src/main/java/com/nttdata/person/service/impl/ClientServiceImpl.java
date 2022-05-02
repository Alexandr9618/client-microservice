package com.nttdata.person.service.impl;

import com.nttdata.person.dto.mapper.ClientMapper;
import com.nttdata.person.dto.request.ClientRequest;
import com.nttdata.person.model.Client;
import com.nttdata.person.service.IPlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.nttdata.person.model.Plan;
import com.nttdata.person.repository.IClientRepository;
import com.nttdata.person.service.IClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements IClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final IClientRepository clientRepository;

    private final ClientMapper clientMapper;

    private final IPlanService planRepository;

    public ClientServiceImpl(IClientRepository clientRepository, ClientMapper clientMapper, IPlanService planRepository) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.planRepository = planRepository;
    }

    @Override
    public Mono<Client> addPerson(ClientRequest request) {
        Mono<Plan> plan = planRepository.findByName(request.getPlan().getName());
        Mono<Client> client = clientMapper.toPostModel(request);
        return plan.flatMap(pt -> client
                .flatMap(p -> {
                    p.setPlan(pt);
                    return clientRepository.save(p)
                            .onErrorResume(e -> {
                                LOGGER.error("[" + getClass().getName() + "][addPerson]" + e);
                                return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request" + e));
                            }).switchIfEmpty(
                                    Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST))
                            );
                }));
    }

    @Override
    public Mono<Client> getPersonById(String personId) {
        return clientRepository.findById(personId)
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][getPersonById]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                }).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public Mono<Client> setUpdatePerson(String id, ClientRequest request) {
        Mono<Plan> personType = planRepository.findByName(request.getPlan().getName());
        return personType.flatMap(pt -> clientRepository.findById(id)
                .flatMap(p -> clientMapper.toPutModel(p, request)
                        .flatMap(per -> {
                            p.setPlan(pt);
                            return clientRepository.save(p);
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
        return clientRepository.deleteById(id)
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][deletePerson]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "" + e));
                });
    }

    @Override
    public Flux<Client> getAllPerson() {
        // TODO Auto-generated method stub
        return clientRepository.findAll()
                .onErrorResume(e -> {
                    LOGGER.error("[" + getClass().getName() + "][getAllPerson]" + e);
                    return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "" + e));
                });
    }

}
