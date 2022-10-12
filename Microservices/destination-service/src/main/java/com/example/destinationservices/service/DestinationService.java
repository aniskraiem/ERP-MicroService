package com.example.destinationservices.service;

import com.example.destinationservices.models.Destination;
import com.example.destinationservices.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService implements IDestinationService{

    @Autowired
    private DestinationRepository destinationRepository;


    @Override
    public Destination addDestination(Destination d) {
        return destinationRepository.save(d);

    }

    @Override
    public List<Destination> findAll() {
        return destinationRepository.findAll();
    }

    @Override
    public Destination findDestinationById(Long idDestination) {
        return destinationRepository.findById(idDestination).get();
    }

    @Override
    public Destination updateDestination(Destination destination, Long id) {
        if (destinationRepository.findById(id).isPresent()) {
            Destination e = destinationRepository.findById(id).get();
            e.setPays(destination.getPays());
            e.setVille(destination.getVille());

            return destinationRepository.save(e);
        }
        return null;
    }

    @Override
    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);

    }


}
