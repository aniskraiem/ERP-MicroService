package com.example.hotelservices.repository;


import com.example.hotelservices.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
