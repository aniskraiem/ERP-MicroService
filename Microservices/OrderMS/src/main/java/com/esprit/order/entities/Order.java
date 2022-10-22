package com.esprit.order.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Commande")
public class Order implements Serializable {


	private static final long serialVersionUID = -1741519260556429015L;
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="total")
	private double total;
	@Column(name="description")
	private String description;

	public Order() {
		super();
	}


	public Order(int id, String nom, String prenom, String email, int tel, String poste) {
		this.id = id;
		this.total = total;
		this.description = description;

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
