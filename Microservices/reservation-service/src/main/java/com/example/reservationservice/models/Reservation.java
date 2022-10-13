package com.example.reservationservice.models;


import lombok.*;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode()
@Entity
@Table(name ="reservation")
public class Reservation extends AbstractEntity {


    @Id
    private Long id;

    @Column(name = "DateReservation")
    private Date datereservation;

    @Column(name ="HeureReservation")
    private Date heureReservation;
    @Column(name ="DureSejour")
    private Integer duresejour;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
