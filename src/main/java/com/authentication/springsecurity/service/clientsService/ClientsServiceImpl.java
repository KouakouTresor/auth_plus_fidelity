package com.authentication.springsecurity.service.clientsService;

import com.authentication.springsecurity.model.modelClients.Clients;
import com.authentication.springsecurity.repository.ClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@Service
@AllArgsConstructor
public class ClientsServiceImpl implements ClientsService {
    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public Mono<Clients> SaveClient(Clients client) {

        return clientsRepository.save(client);
    }

    @Override
    public Mono<Clients> SelectClient(String id) {

        return clientsRepository.findById(id);
    }

    @Override
    public Flux<Clients> SelectAll() {

        return clientsRepository.findAll();
    }

    @Override
    public Mono<Clients> FindByFidelityCode(String code){

        return clientsRepository.findByCode(code);
    }

   @Override
   public Flux<Clients> FindByName(String name){
        return clientsRepository.findByName(name);
   }

   public Flux<Clients> FindByPoint(int points){
        return clientsRepository.findByPoint(points);
   }
    @Override
    public Mono<Void> DeleteClient(String id) {
        return clientsRepository.deleteById(id);
    }

}
