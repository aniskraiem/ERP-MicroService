package com.example.hotelservices.controller;


import com.example.hotelservices.models.Hotel;
import com.example.hotelservices.repository.HotelRepository;
import com.example.hotelservices.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/hotel")
public class HotelRestAPI {
    @Autowired
    private IHotelService iHotelService;

    @Autowired
    HotelRepository hotelRepository;


    @PostMapping("/add")
    public ResponseEntity<Hotel> CreateHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<Hotel>(iHotelService.addHotel(hotel) , HttpStatus.CREATED) ;
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Hotel> HotelList(){
        return iHotelService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Hotel> findOne(@PathVariable("id") Long id){
        return  new ResponseEntity<Hotel>( iHotelService.findHotelById(id) ,HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Hotel modify(@RequestBody Hotel Hotel,@PathVariable("id") Long id) {
        return iHotelService.updateHotel(Hotel , id);
    }


    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        iHotelService.deleteHotel(id);
    }

}
