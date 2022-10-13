package com.example.hoteltinationservices.service;

import com.example.hotelservices.models.Hotel;

import java.util.List;

public interface IHotelService {

    Hotel addHotel(Hotel e);

    List<Hotel> findAll();

    Hotel findHotelById(Long idEvent);

    Hotel updateHotel(Hotel hotel, Long id);

    void deleteHotel(Long id);



}
