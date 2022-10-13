package com.example.reservationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reservationservice.service.IReservationService;
import java.util.List;
import com.example.reservationservice.repository.ReservationRepository;
import  com.example.reservationservice.models.Reservation;
@Service
public class ReservationService implements  IReservationService{

    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public Reservation addReservation(Reservation d) {
        return reservationRepository.save(d);

    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findReservationById(Long idDestination) {
        return reservationRepository.findById(idDestination).get();
    }

    @Override
    public Reservation updateReservation(Reservation reservation, Long id) {
        if (reservationRepository.findById(id).isPresent()) {
            Reservation e = reservationRepository.findById(id).get();
            e.setDatereservation(reservation.getDatereservation());
            e.setHeureReservation(reservation.getHeureReservation());
            e.setDuresejour(reservation.getDuresejour());

            return reservationRepository.save(e);
        }
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);

    }


}
