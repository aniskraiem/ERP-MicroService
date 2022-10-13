package com.example.clientservices.controller;


import com.example.clientservices.models.Client;
import com.example.clientservices.repository.ClientRepository;
import com.example.clientservices.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/client")
public class ClientRestAPI {
    @Autowired
    private IClientService iClientService;

    @Autowired
    ClientRepository clientRepository;


    @PostMapping("/add")
    public ResponseEntity<Client> CreateClient(@RequestBody Client client){
        return new ResponseEntity<Client>(iClientService.addClient(client) , HttpStatus.CREATED) ;
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Client> ClientList(){
        return iClientService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> findOne(@PathVariable("id") Long id){
        return  new ResponseEntity<Client>( iClientService.findClientById(id) ,HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client modify(@RequestBody Client Client,@PathVariable("id") Long id) {
        return iClientService.updateHlient(Client , id);
    }


    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        iClientService.deleteClient(id);
    }

}
