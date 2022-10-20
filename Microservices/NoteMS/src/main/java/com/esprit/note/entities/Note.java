package com.esprit.note.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Note")
public class Note implements Serializable {


	private static final long serialVersionUID = -1741519260556429015L;
	@Column(name="id")
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="titre")
	private String titre; 
	@Column(name="content")
	private String content; 
	
	public Note() {
		super();
	}

	public Note(int id,String nom,String titre,String content) {
		super();
		this.id = id;
		this.titre = titre;
		this.content = content;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
}
