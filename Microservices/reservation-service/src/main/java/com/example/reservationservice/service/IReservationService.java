package com.example.reservationservice.service;

import java.util.List;
import com.example.reservationservice.models.Reservation;
public interface IReservationService {

    Reservation addReservation(Reservation r);

    List<Reservation> findAll();

    Reservation findReservationById(Long idEvent);

    Reservation updateReservation(Reservation reservation, Long id);

    void deleteReservation(Long id);



}
