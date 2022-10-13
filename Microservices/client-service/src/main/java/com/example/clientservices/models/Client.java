package com.example.clientservices.models;


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
@Table(name ="client")
public class Client extends AbstractEntity {


    @Id
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name ="email")
    private String email;

    @Column(name ="nationnalité")
    private String nationnalité;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
