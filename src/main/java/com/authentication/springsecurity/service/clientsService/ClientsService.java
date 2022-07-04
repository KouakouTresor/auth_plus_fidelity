package com.authentication.springsecurity.service.clientsService;

import com.authentication.springsecurity.model.modelClients.Clients;
import java.util.List;
import java.util.Optional;


public interface ClientsService {
    public Optional<Clients> SelectClient(String id);
    public List<Clients> SelectAll();
    public Clients SaveClient(Clients client);
    public Void DeleteClient(String id);
    public Clients FindByFidelityCode(String code);
    public List<Clients> FindByName(String name);
    public List<Clients> FindByPoint(int points);
}
