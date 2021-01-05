package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.modal.Area;

public interface AreaDAO {
	 List<Area> get();
	 Area get(int id);
	 void save(Area area);
	 void delete(int id);
}
