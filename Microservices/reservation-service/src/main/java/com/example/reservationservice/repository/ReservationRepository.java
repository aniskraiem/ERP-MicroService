package com.example.reservationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.reservationservice.models.Reservation;
@Repository

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
