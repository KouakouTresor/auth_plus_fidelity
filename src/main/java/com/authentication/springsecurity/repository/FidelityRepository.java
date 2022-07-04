package com.authentication.springsecurity.repository;


import com.authentication.springsecurity.entity.entityClients.FidelityCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FidelityRepository extends JpaRepository<FidelityCard, String> {

}
