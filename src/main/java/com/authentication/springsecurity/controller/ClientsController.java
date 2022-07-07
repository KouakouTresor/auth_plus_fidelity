package com.authentication.springsecurity.controller;


import com.authentication.springsecurity.entity.entityClients.Clients;

import com.authentication.springsecurity.service.clientsService.ClientsServiceImpl;
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






    @GetMapping
    public  ResponseEntity<List<Clients>>  selectAll(){
        log.info("******* GET ALL CLIENTS *******");
        List<Clients> clients = clientsServiceImpl.SelectAll();
        if(clients == null){
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found");
        }
        return new ResponseEntity<List<Clients>>(clients, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Clients> getClientById(@PathVariable("id") Long id) {
        Clients client = clientsServiceImpl.SelectClient(id);
        return new ResponseEntity<Clients>(client, HttpStatus.OK);
    }

  /*  @RequestMapping(value = "/search/{name}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Clients> getClientByName(@PathVariable("name") String name) {
        Clients clientData = clientsServiceImpl.FindByName(name);
        return new ResponseEntity<Clients>(clientData, HttpStatus.OK);

    }
*/

    @PostMapping("/post")
    public ResponseEntity<Clients> createTutorial(@RequestBody Clients client) {
        try {
   
            Clients _client = clientsServiceImpl.SaveClient(client);

            return new ResponseEntity<>(_client, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/delete/{id}" )
    public ResponseEntity <Void> deleteClient(@PathVariable("id") Long id){
        log.info("******* DELETE CLIENT *******");
        clientsServiceImpl.DeleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable("id") Long id, @RequestBody Clients client){
        Clients clientData = clientsServiceImpl.SelectClient(id);
        if(clientData != null){
            client.setName(client.getName());
            client.setActive(client.getActive());
            client.setAddress(client.getAddress());
            client.setFidelity(client.getFidelity());
            client.setCode(client.getCode());
            client.setPhone(client.getPhone());
            client.setVille(client.getVille());
            client.setEmail(client.getEmail());
            return new ResponseEntity<>(clientsServiceImpl.SaveClient(client), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  


   
 
}
