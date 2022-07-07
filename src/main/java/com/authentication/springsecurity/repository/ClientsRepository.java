package com.authentication.springsecurity.repository;
import com.authentication.springsecurity.entity.entityClients.Clients;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, String> {
    public Clients findByCode(String code);
    Clients findByName(String name);
    Clients findById(Long id);
    void deleteById(Long name);


    /*     public List<Clients> findByPoint(int points); */

}
