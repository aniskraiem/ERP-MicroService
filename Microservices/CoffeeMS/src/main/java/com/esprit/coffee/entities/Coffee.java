package com.esprit.coffee.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Coffee")
public class Coffee implements Serializable {


	private static final long serialVersionUID = -1741519260556429015L;
	@Column(name="id")
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nom")
	private String nom; 
	@Column(name="prix")
	private double prix; 
	@Column(name="description")
	private String description; 
	
	public Coffee() {
		super();
	}

	public Coffee(int id,String nom,double prix,String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.description = description;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
