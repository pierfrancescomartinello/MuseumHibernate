package com.museum.MuseumHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="area")
public class Area {
	
	public Area() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="areaid")
	public Integer areaId;
	
	@Column(name="areaname")
	private String areaName;
	
	@Column(name="areastyle")
	private String areaStyle;
	
	@Column(name="areacuratorid")
	private int areaCuratorId;
	
	@Column(name="isaccessible")
	private boolean isAccessible;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaStyle() {
		return areaStyle;
	}

	public void setAreaStyle(String areaStyle) {
		this.areaStyle = areaStyle;
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