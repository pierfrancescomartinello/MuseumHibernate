package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.modal.Area;
import com.museum.MuseumHibernate.service.AreaService;

public interface AreaService {
	List<Area> get();
	Area get(int id);
	void save(Area artwork);
 	void delete(int id);
}