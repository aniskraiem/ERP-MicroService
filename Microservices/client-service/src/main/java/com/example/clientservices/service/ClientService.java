package com.example.clientservices.service;

import com.example.clientservices.models.Client;
import com.example.clientservices.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService{

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Client addClient(Client d) {
        return clientRepository.save(d);

    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClientById(Long idClient) {
        return clientRepository.findById(idClient).get();
    }

    @Override
    public Client updateClient(Client client, Long id) {
        if (clientRepository.findById(id).isPresent()) {
            Client e = clientRepository.findById(id).get();
            e.setPays(client.getPays());
            e.setVille(client.getVille());

            return clientRepository.save(e);
        }
        return null;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }


}
