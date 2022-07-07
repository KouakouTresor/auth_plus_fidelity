package com.authentication.springsecurity.repository;
import com.authentication.springsecurity.entity.entityClients.Clients;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, String> {
    public Clients findByCode(String code);
    public void deleteById(Long id);
    Clients findByName(String name);
    Clients findById(Long id);


    /*     public List<Clients> findByPoint(int points); */

}
