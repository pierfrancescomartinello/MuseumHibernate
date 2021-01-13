package com.museum.MuseumHibernate.model;

import java.awt.image.BufferedImage;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="artwork")
public class Artwork {
	public Artwork() {
		
	}
	
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
		
		/*
		this.image = image;
		this.miniature = miniature;
		*/
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="artworkid")
	public int artworkId;
	
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
	public int areaId;
	
	@Lob
	@Column(name="immagine", columnDefinition="BLOB")
	public byte[] image;
	
	@Lob
	@Column(name="miniatura", columnDefinition="BLOB")
	public byte[] miniature;

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