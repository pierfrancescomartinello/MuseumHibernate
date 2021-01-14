package com.museum.MuseumHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="area")
public class Area {
	
	public Area() {
		
	}
	
	public Area(Integer areaId, String areaName, String description, int areaCuratorId, boolean isAccessible,
			byte[] areaMiniatura) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
		this.description = description;
		this.areaCuratorId = areaCuratorId;
		this.isAccessible = isAccessible;
		this.areaMiniatura = areaMiniatura;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="areaid")
	public Integer areaId;
	
	@Column(name="areaname")
	private String areaName;
	
	@Column(name="description")
	public String description;
	
	@Column(name="areacuratorid")
	private int areaCuratorId;
	
	@Column(name="isaccessible")
	private boolean isAccessible;

	@Lob
	@Column(name="areaminiatura", columnDefinition="BLOB")
	public byte[] areaMiniatura;
	
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getAreaCuratorId() {
		return areaCuratorId;
	}

	public void setAreaCuratorId(Integer areaCuratorId) {
		this.areaCuratorId = areaCuratorId;
	}

	public boolean isAccessible() {
		return isAccessible;
	}

	public void setAccessible(boolean isAccessible) {
		this.isAccessible = isAccessible;
	}

}