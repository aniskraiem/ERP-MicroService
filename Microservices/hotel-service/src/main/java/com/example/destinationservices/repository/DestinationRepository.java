package com.example.destinationservices.repository;


import com.example.destinationservices.models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DestinationRepository extends JpaRepository<Destination,Long> {
}
