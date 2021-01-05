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
	private Integer artworkId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	@Column(name="submissiondate")
	private Date date;
	
	@Column(name="simpledescription")
	private String simpleDescription;
	
	@Column(name="completedescription")
	private String completeDescription;
	
	@Column(name="areaname")
	private String areaName;
	
	@Override
	public String toString() {
		return "Artwork " + name + " " + author + " " + date + " " + simpleDescription + " " + completeDescription + " " + areaName;
	}

	public Integer getArtworkId() {
		return artworkId;
	}

	public void setArtworkId(Integer artworkId) {
		this.artworkId = artworkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSimpleDescription() {
		return simpleDescription;
	}

	public void setSimpleDescription(String simpleDescription) {
		this.simpleDescription = simpleDescription;
	}

	public String getCompleteDescription() {
		return completeDescription;
	}

	public void setCompleteDescription(String completeDescription) {
		this.completeDescription = completeDescription;
	}

	public String getArea() {
		return areaName;
	}

	public void setArea(String areaName) {
		this.areaName = areaName;
	}
	
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