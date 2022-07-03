package com.authentication.springsecurity.controller;


import com.authentication.springsecurity.model.modelClients.Clients;
import com.authentication.springsecurity.service.clientsService.ClientsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/clients")

@RestController
@Slf4j
public class ClientsController {

    @Autowired
    ClientsServiceImpl clientsServiceImpl;


    @GetMapping(value="/auth", produces = "application/json")
    public Mono<String> checkBasicAuth()
    {
        log.info("****** Verifica Autenticazione *******");

        return Mono.just("Auteticazione Ok");
    }

    @PostMapping(value="/insert", produces ="application/json")
    public ResponseEntity<Mono<Clients>> insertCli(@RequestBody Clients newClient) {
        log.info("******* INSERT A CLIENT *******");
        Mono<Clients> client = clientsServiceImpl.SaveClient(newClient);
        return new ResponseEntity<Mono<Clients>>(client, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
   public ResponseEntity<Mono<Void>> deleteClient(@PathVariable("id") String id){
        log.info("******* DELETE A CLIENT *******");
        return new ResponseEntity<Mono<Void>> (clientsServiceImpl.DeleteClient(id), HttpStatus.OK);
    }


    @RequestMapping(value="/search/all", method = RequestMethod.GET, produces ="application/json")

    public  ResponseEntity<Flux<Clients>>  selectAll(){
        log.info("******* GET ALL CLIENTS *******");
        Flux<Clients> clients = clientsServiceImpl.SelectAll()
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found")));
        return new ResponseEntity<Flux<Clients>>(clients, HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Mono<Clients>> selectClient(@PathVariable("id") String id ){
        log.info("******* GET USER BY ID *******");
        Mono<Clients> client = clientsServiceImpl.SelectClient(id);
        return new ResponseEntity<Mono<Clients>>(client, HttpStatus.OK);

    }

    @RequestMapping(value="/search/{code}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Mono<Clients>> selectByFidelityCode(@PathVariable("code") String code){
        log.info("******* GET USER BY CODE FIDELITY"+ code + "*******");
        Mono<Clients> client = clientsServiceImpl.FindByFidelityCode(code)
         .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found")));
        return new ResponseEntity<Mono<Clients>>(client,  HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Flux<Clients>> selectClientByName(@PathVariable("name") String name ){
        log.info("******* GET USER BY NAME *******");
        Flux<Clients> clients = clientsServiceImpl.FindByName(name)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found")));
        return new ResponseEntity<Flux<Clients>>(clients, HttpStatus.OK);
    }

    @GetMapping(value = "/search/{points}", produces ="application/json")
    public ResponseEntity<Flux<Clients>>  selectClientByPoints(@PathVariable("points") int points){
        log.info("******* GET USER BY FIDELITY POINTS *******");
        Flux<Clients> clients = clientsServiceImpl.FindByPoint(points)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found")));
        return new ResponseEntity<Flux<Clients>>(clients, HttpStatus.OK);
    }




}
