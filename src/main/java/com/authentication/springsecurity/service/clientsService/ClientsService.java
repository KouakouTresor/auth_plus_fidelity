package com.authentication.springsecurity.service.clientsService;

import com.authentication.springsecurity.entity.entityClients.Clients;

import java.util.List;
import java.util.Optional;



public interface ClientsService {
    public Optional<Clients> SelectClient(Long id);
    public List<Clients> SelectAll();
    public Clients SaveClient(Clients client);
    public String DeleteClient(Long id);
    public Clients FindByFidelityCode(String code);
    public Optional<Clients> FindByName(String name);
   /*  public List<Clients> FindByPoint(int points); */
}
