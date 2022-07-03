package com.authentication.springsecurity.service.clientsService;

import com.authentication.springsecurity.model.modelClients.Clients;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface ClientsService {
    public Mono<Clients> SelectClient(String id);
    public Flux<Clients> SelectAll();
    public Mono<Clients> SaveClient(Clients client);
    public Mono<Void> DeleteClient(String id);
    public Mono<Clients> FindByFidelityCode(String code);
    public Flux<Clients> FindByName(String name);
    public Flux<Clients> FindByPoint(int points);
}
