package com.museum.MuseumHibernate.modal;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visit")
public class Visit {
	
	public Visit() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="visitid")
	private Integer visitId;
	
	@Column(name="visitdate")
	private Date visitDate;
	
	@Column(name="areaname")
	private String areaName;

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
	public void showAreas() {
		
	}

	public Area selectArea() {
		return null;
	}

	public void exitArea() {
		
	}

	public void selectArtwork() {
		
	}
	public void exitArtwork() {
		
	}

	public void endVisit() {
		
	}
	
}