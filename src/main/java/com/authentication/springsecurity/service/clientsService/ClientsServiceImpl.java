package com.authentication.springsecurity.service.clientsService;

import com.authentication.springsecurity.entity.entityClients.Clients;
import com.authentication.springsecurity.repository.ClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public Clients SaveClient(Clients client) {
        return clientsRepository.save(client);
    }

    @Override
    public Optional<Clients> SelectClient(int id) {

        return clientsRepository.findById(String.valueOf(id));
    }

    @Override
    public List<Clients> SelectAll() {

        return clientsRepository.findAll();
    }

    @Override
    public Clients FindByFidelityCode(String code){

        return clientsRepository.findByCode(code);
    }

   public List<Clients> FindByName(String name){
        return clientsRepository.findByName(name);
   }

/*     @Override
   public List<Clients> FindByPoint(int points){
        return clientsRepository.findByPoint(points);
   } */

    @Override
    public String DeleteClient(int id) {
        return "supprimé" + id;

    }

}
