package com.museum.MuseumHibernate.modal;

import java.awt.image.BufferedImage;
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
	
	public Artwork(Integer artworkId, String name, String author, Date date, String simpleDescription,
			String completeDescription, Integer areaId, BufferedImage image, BufferedImage miniature) {
		super();
		this.artworkId = artworkId;
		this.name = name;
		this.author = author;
		this.date = date;
		this.simpleDescription = simpleDescription;
		this.completeDescription = completeDescription;
		this.areaId = areaId;
		this.image = image;
		this.miniature = miniature;
	}
	@Column(name="author")
	public String author;
	
	@Column(name="submissiondate")
	public Date date;
	
	@Column(name="simpledescription")
	public String simpleDescription;
	
	@Column(name="completedescription")
	public String completeDescription;
	
	@Column(name="areaid")
	public Integer areaId;
	
	@Column(name="immagine")
	public BufferedImage image;
	
	@Column(name="miniatura")
	public BufferedImage miniature;
	

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