package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.modal.Visit;
import com.museum.MuseumHibernate.service.VisitService;

public interface VisitService {
	List<Visit> get();
	Visit get(int id);
	void save(Visit artwork);
 	void delete(int id);
}