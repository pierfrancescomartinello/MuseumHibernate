package com.museum.MuseumHibernate.modal;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artwork")
public class Artwork {
	public Artwork() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="artworkid")
	public Integer artworkId;
	
	@Column(name="name")
	public String name;
	
	@Column(name="author")
	public String author;
	
	@Column(name="submissiondate")
	public Date date;
	
	@Column(name="simpledescription")
	public String simpleDescription;
	
	@Column(name="completedescription")
	public String completeDescription;
	
	@Column(name="areaid")
	public String areaId;
	

	/*
		da integrare tramite richieste POST e DELETE
	public void addArtwork(Artwork artwork){
		this.artworks.add(artwork);
	}
	
	public void deleteArtwork(Artwork artwork){
		this.artworks.remove(artwork);
	}
	*/
}