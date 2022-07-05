package com.authentication.springsecurity.service.clientsService;

import com.authentication.springsecurity.entity.entityClients.Clients;

import java.util.List;
import java.util.Optional;



public interface ClientsService {
    public Optional<Clients> SelectClient(int id);
    public List<Clients> SelectAll();
    public Clients SaveClient(Clients client);
    public String DeleteClient(int id);
    public Clients FindByFidelityCode(String code);
    public List<Clients> FindByName(String name);
   /*  public List<Clients> FindByPoint(int points); */
}
