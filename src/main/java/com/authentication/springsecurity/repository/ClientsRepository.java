package com.authentication.springsecurity.repository;


import com.authentication.springsecurity.model.modelClients.Clients;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, String> {
    public Clients findByCode(String code);
    public List<Clients> findByName(String name);
    public List<Clients> findByPoint(int points);

}
