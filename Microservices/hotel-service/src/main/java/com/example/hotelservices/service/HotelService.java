package com.example.hotelservices.service;

import com.example.hotelservices.models.Hotel;
import com.example.hotelservices.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService implements IHotelService{

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Hotel addHotel(Hotel d) {
        return hotelRepository.save(d);

    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findHotelById(Long idHotel) {
        return hotelRepository.findById(idHotel).get();
    }

    @Override
    public Hotel updateHotel(Hotel hotel, Long id) {
        if (hotelRepository.findById(id).isPresent()) {
            Hotel e = hotelRepository.findById(id).get();
            e.setPays(hotel.getPays());
            e.setVille(hotel.getVille());

            return hotelRepository.save(e);
        }
        return null;
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);

    }


}
