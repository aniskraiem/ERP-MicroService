package com.example.hotelservices.models;


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
@Table(name ="hotel")
public class Hotel extends AbstractEntity {


    @Id
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name ="caracteristique")
    private String caracteristique;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
