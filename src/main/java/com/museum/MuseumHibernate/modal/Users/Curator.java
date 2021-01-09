package com.museum.MuseumHibernate.modal.Users;

import com.museum.MuseumHibernate.modal.Artwork;

import com.museum.MuseumHibernate.modal.Area;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Curator extends EmployeeDecorator{

	private ArrayList<Area> assignedAreas;

	public Curator(Worker specializedEmployee) {
		super(specializedEmployee);
	}

	public void addAreas(ArrayList<Area> areas){
		for(Area area: assignedAreas){
			if(area.getAreaCuratorId() == this.getEmployeeId()){
				this.assignedAreas.add(area);
			}
		}
	}
/*
	public void curatorSetArea(Artwork artworkToModify, Area newArea){
		if(this.assignedAreas.contains(artworkToModify.getArea())){
			artworkToModify.setArea(newArea.getAreaName());
		}
	}
	
	public void curatorSetAreaName(Area area, String newAreaName){
		if(this.assignedAreas.contains(area))
			area.setAreaName(newAreaName);
	}

	public void curatorSetAreaStyle(Area area, String newAreaStyle){
		area.setAreaStyle(newAreaStyle);
	}

	public void curatorSetArtworkSimpleDescription(Artwork artworkToModify, String simpleDescription){
		if(assignedAreas.contains(artworkToModify.getArea())){
			artworkToModify.setSimpleDescription(simpleDescription);
		}
	}

	public void curatorSetArtworkCompleteDescription(Artwork artworkToModify, String completeDescription){
		if(this.assignedAreas.contains(artworkToModify.getArea())){
			artworkToModify.setCompleteDescription(completeDescription);
		}
	}
*/
}
