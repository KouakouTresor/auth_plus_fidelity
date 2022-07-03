package com.authentication.springsecurity.repository;


import com.authentication.springsecurity.model.modelClients.Clients;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface ClientsRepository extends ReactiveMongoRepository<Clients, String> {
    public Mono<Clients> findByCode(String code);
    public Flux<Clients> findByName(String name);

    @Query("{'fidelity.points': {$gt:?0} }")
    public Flux<Clients> findByPoint(int points);

}
