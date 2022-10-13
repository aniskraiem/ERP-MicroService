package com.example.destinationservices.controller;


import com.example.destinationservices.models.Destination;
import com.example.destinationservices.repository.DestinationRepository;
import com.example.destinationservices.service.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/destination")
public class DestinationRestAPI {
    @Autowired
    private IDestinationService iDestinationService;

    @Autowired
    DestinationRepository destinationRepository;


    @PostMapping("/add")
    public ResponseEntity<Destination> CreateDestination(@RequestBody Destination destination){
        return new ResponseEntity<Destination>(iDestinationService.addDestination(destination) , HttpStatus.CREATED) ;
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Destination> DestinationList(){
        return iDestinationService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Destination> findOne(@PathVariable("id") Long id){
        return  new ResponseEntity<Destination>( iDestinationService.findDestinationById(id) ,HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Destination modify(@RequestBody Destination Destination,@PathVariable("id") Long id) {
        return iDestinationService.updateDestination(Destination , id);
    }


    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        iDestinationService.deleteDestination(id);
    }

}
