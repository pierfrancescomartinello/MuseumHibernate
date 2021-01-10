package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.model.Area;
import com.museum.MuseumHibernate.service.AreaService;

public interface AreaService {
	List<Area> get();
	List<Area> getAreaId(int id);
	List<Area> getAreaName(String areaName);
	List<Area> getAreaStyle(String areaStyle);
	List<Area> getAreaCuratorId(String areaCuratorId);
	void save(Area artwork);
 	void delete(int id);
}