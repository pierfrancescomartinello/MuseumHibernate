package com.museum.MuseumHibernate.service;

import java.util.List;
import java.util.Date;

import com.museum.MuseumHibernate.modal.Visit;
import com.museum.MuseumHibernate.service.VisitService;

public interface VisitService {
	List<Visit> get();
	Visit get(int id);
	void save(Visit artwork);
 	void delete(int id);
	List<Visit> getAreaName (String areaname);
	List<Visit> get(Date visitdate);
}