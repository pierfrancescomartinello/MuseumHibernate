package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.model.Area;

public interface AreaDAO {
		List<Area> get();
		List<Area> getAreaName(String areaName);
		List<Area> getAreaStyle(String areaStyle);
		List<Area> getAreaCuratorId(String areaCuratorId);
		List<Area> getAreaId(int id);
		void save(Area area);
		void delete(int id);
}
	