package com.museum.MuseumHibernate.dao;

import java.util.List;
import java.util.Date;

import com.museum.MuseumHibernate.modal.Visit;

public interface VisitDAO {
	 List<Visit> get();
	 Visit get(int id);
	 void save(Visit visit);
	 void delete(int id);
 	 List<Visit> getAreaName (String areaname);
	 List<Visit> get(Date visitdate);
}
