package com.authentication.springsecurity.service.clientsService;

import com.authentication.springsecurity.entity.entityClients.Clients;
import com.authentication.springsecurity.entity.entityClients.FidelityCard;

import java.util.List;
import java.util.Optional;



public interface ClientsService {
    public Clients SelectClient(Long id);
    public List<Clients> SelectAll();
    public Clients SaveClient(Clients client);
    public void DeleteClient(Long id);
    public Clients FindByFidelityCode(String code);
    public Clients FindByName(String name);
   /*  public List<Clients> FindByPoint(int points); */
}
