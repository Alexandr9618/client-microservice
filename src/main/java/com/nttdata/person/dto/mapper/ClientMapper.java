package com.nttdata.person.dto.mapper;

import java.util.Date;

import com.nttdata.person.dto.response.PlanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.nttdata.person.dto.request.ClientRequest;
import com.nttdata.person.dto.response.ClientResponse;
import com.nttdata.person.model.Client;
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
public class ClientMapper {

    private final PlanMapper planMapper;

    /**
     * This method convert request to model
     *
     * @param request request of personRequest
     * @return Client model
     */
    public Mono<Client> toPostModel(ClientRequest request) {
        return Mono.just(new Client(request.getFirstName(),
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
     * @param client client
     * @param request request
     * @return client
     */
    public Mono<Client> toPutModel(Client client, ClientRequest request) {
        client.setEmail(request.getEmail());
        client.setIphone(request.getIphone());
        client.setAddress(request.getAddress());
        client.setUpdatedAt(AppUtil.dateFormat(new Date()));
        return Mono.just(client);
    }

    /**
     * @param client client
     * @return client
     */
    public Mono<ClientResponse> toMonoResponse(Mono<Client> client) {
        return client.flatMap(p -> {
            Mono<PlanResponse> plan = planMapper
                    .toMonoResponse(Mono.just(p.getPlan()));
            return plan.flatMap(pt -> Mono.just(
                            new ClientResponse(p.getId(), p.getFirstName(), p.getLastName(),
                                    p.getDocumentType(), p.getDocument(), p.getBirthDate(), p.getEmail(),
                                    p.getIphone(), p.getAddress(), p.getCreatedAt(), p.getUpdatedAt(), pt)
                    )
            );
        });
    }

    /**
     * @param clients clients
     * @return clients
     */
    public Flux<ClientResponse> toFluxResponse(Flux<Client> clients) {
        return clients.flatMap(c -> toMonoResponse(Mono.just(c)));
    }
}
