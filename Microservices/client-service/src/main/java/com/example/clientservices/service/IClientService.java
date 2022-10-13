package com.example.clienttinationservices.service;

import com.example.clientservices.models.Client;

import java.util.List;

public interface IClientService {

    Client addClient(Client e);

    List<Client> findAll();

    Client findClientById(Long idEvent);

    Client updateClient(Client client, Long id);

    void deleteClient(Long id);



}
