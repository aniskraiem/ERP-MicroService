package com.example.reservationservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.example.reservationservice.service.IReservationService;
import com.example.reservationservice.repository.ReservationRepository;
import com.example.reservationservice.models.Reservation;
import java.util.List;


@RestController
@RequestMapping(value = "/destination")
public class ReservationRestAPI {
    @Autowired
    private IReservationService iReservationService;

    @Autowired
    ReservationRepository reservationRepository;


    @PostMapping("/add")
    public ResponseEntity<Reservation> CreateDestination(@RequestBody Reservation reservation){
        return new ResponseEntity<Reservation>(iReservationService.addReservation(reservation ) , HttpStatus.CREATED) ;
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Reservation> DestinationList(){
        return iReservationService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Reservation> findOne(@PathVariable("id") Long id){
        return  new ResponseEntity<Reservation>( iReservationService.findReservationById(id) ,HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reservation modify(@RequestBody Reservation Reservation, @PathVariable("id") Long id) {
        return iReservationService.updateReservation(Reservation, id);
    }


    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        iReservationService.deleteReservation(id);
    }

}
