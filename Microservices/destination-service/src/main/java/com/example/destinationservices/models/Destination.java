package com.example.destinationservices.models;


import lombok.*;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode()
@ Entity
@Table(name ="destination")
public class Destination extends AbstractEntity {


    @Id
    private Long id;

    @Column(name = "pays")
    private String pays;

    @Column(name ="ville")
    private String ville;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
