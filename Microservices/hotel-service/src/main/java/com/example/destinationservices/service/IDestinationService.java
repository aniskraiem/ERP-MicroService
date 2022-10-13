package com.example.destinationservices.service;

import com.example.destinationservices.models.Destination;

import java.util.List;

public interface IDestinationService {

    Destination addDestination(Destination e);

    List<Destination> findAll();

    Destination findDestinationById(Long idEvent);

    Destination updateDestination(Destination destination, Long id);

    void deleteDestination(Long id);



}
