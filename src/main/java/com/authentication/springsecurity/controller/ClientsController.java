package com.authentication.springsecurity.controller;


import com.authentication.springsecurity.entity.entityClients.Clients;
import com.authentication.springsecurity.entity.entityClients.FidelityCard;
import com.authentication.springsecurity.entity.entitytUser.User;
import com.authentication.springsecurity.repository.ClientsRepository;
import com.authentication.springsecurity.repository.UserRepository;
import com.authentication.springsecurity.service.clientsService.ClientsServiceImpl;
import com.authentication.springsecurity.service.clientsService.FidelityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/clients")
@Slf4j
public class ClientsController {

    @Autowired
    ClientsServiceImpl clientsServiceImpl;

    @Autowired
    FidelityService fidelityService;


  /*   @PostMapping(value="/insert", produces ="application/json")
    public ResponseEntity<Clients> insertCli(@RequestBody Clients newClient, FidelityCard newFidelity) {
        log.info("******* INSERT A CLIENT *******");
        Clients client = clientsServiceImpl.SaveClient(newClient);
        FidelityCard fidelity = fidelityService.SaveFidelity(newFidelity);
        if(fidelity != null){
            client.setFidelity(fidelity);
        } else {
            new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rensegnez les information sur la carte de fidelité");
        }
        return new ResponseEntity<Clients>(client, HttpStatus.CREATED);
    } */

/*     @DeleteMapping(value = "/delete/{id}", produces = "application/json")
   public String deleteClient(@PathVariable("id") int id){
        log.info("******* DELETE A CLIENT *******");
         clientsServiceImpl.DeleteClient(id);
         return "client supprimé";

    } */


   /*  @RequestMapping(value="/search/all", method = RequestMethod.GET, produces ="application/json") */
   /* public  ResponseEntity<List<Clients>>  selectAll(){
        log.info("******* GET ALL CLIENTS *******");
        List<Clients> clients = clientsServiceImpl.SelectAll();
        if(clients == null){
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found");
        }
        return new ResponseEntity<List<Clients>>(clients, HttpStatus.OK);
    }
**/
  /*   @RequestMapping(value = "/search/{id}", method = RequestMethod.GET, produces ="application/json")
    public Optional<Clients> selectClient(@PathVariable("id") int id ){
        log.info("******* GET USER BY ID *******");
        Optional<Clients> client = clientsServiceImpl.SelectClient(id);
        return client;

    }

    @RequestMapping(value="/search/{code}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Clients> selectByFidelityCode(@PathVariable("code") String code){
        log.info("******* GET USER BY CODE FIDELITY"+ code + "*******");
        Clients client = clientsServiceImpl.FindByFidelityCode(code);
        if(client == null){
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found");
        }
        return new ResponseEntity<Clients>(client,  HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<List<Clients>> selectClientByName(@PathVariable("name") String name ){
        log.info("******* GET USER BY NAME *******");
        List<Clients> clients = clientsServiceImpl.FindByName(name);
                if(clients == null){
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found");
                }
        return new ResponseEntity<List<Clients>>(clients, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable("id") int id, @RequestBody Clients client){
        Optional<Clients> clientData = clientsServiceImpl.SelectClient(id);
        if(clientData.isPresent()){
            Clients _client = clientData.get();
            _client.setName(client.getName());
            _client.setActive(client.getActive());
            _client.setAddress(client.getAddress());
            _client.setFidelity(client.getFidelity());
            _client.setCode(client.getCode());
            _client.setPhone(client.getPhone());
            _client.setVille(client.getVille());
            _client.setEmail(client.getEmail());
                    return new ResponseEntity<>(clientsServiceImpl.SaveClient(_client), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } */
  /*   @GetMapping(value = "/search/{points}", produces ="application/json")
    public ResponseEntity<List<Clients>>  selectClientByPoints(@PathVariable("points") int points){
        log.info("******* GET USER BY FIDELITY POINTS *******");
        List<Clients> clients = clientsServiceImpl.FindByPoint(points);
        if(clients == null){
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found");
        }
        return new ResponseEntity<List<Clients>>(clients, HttpStatus.OK);
    }

 */

    @Autowired
    private ClientsRepository clientsRepository;

 /*   @GetMapping
    public List<Clients> getUsers(){
        return clientsRepository.findAll();
    }
*/
    @GetMapping
    public  ResponseEntity<List<Clients>>  selectAll(){
        log.info("******* GET ALL CLIENTS *******");
        List<Clients> clients = clientsServiceImpl.SelectAll();
        if(clients == null){
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found");
        }
        return new ResponseEntity<List<Clients>>(clients, HttpStatus.OK);
    }

    @RequestMapping("/search/{name}")
    public ResponseEntity<Clients> getClientById(@PathVariable("name") String name) {
        Optional<Clients> clientData = clientsServiceImpl.FindByName(name);
        if (clientData.isPresent()) {
            return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Clients> createTutorial(@RequestBody Clients client) {
        try {
            Clients _client = clientsServiceImpl.SaveClient(client);
            return new ResponseEntity<>(_client, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable("id") Long id, @RequestBody Clients client){
        Optional<Clients> clientData = clientsServiceImpl.SelectClient(id);
        if(clientData.isPresent()){
            Clients _client = clientData.get();
            _client.setName(client.getName());
            _client.setActive(client.getActive());
            _client.setAddress(client.getAddress());
            _client.setFidelity(client.getFidelity());
            _client.setCode(client.getCode());
            _client.setPhone(client.getPhone());
            _client.setVille(client.getVille());
            _client.setEmail(client.getEmail());
            return new ResponseEntity<>(clientsServiceImpl.SaveClient(_client), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public String deleteClient(@PathVariable("id") Long id){
        log.info("******* DELETE A CLIENT *******");
        clientsServiceImpl.DeleteClient(id);
        return "client supprimé";

    }
}
