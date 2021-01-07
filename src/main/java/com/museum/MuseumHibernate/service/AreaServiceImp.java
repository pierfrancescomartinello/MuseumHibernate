package com.museum.MuseumHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.MuseumHibernate.dao.AreaDAO;
import com.museum.MuseumHibernate.modal.Area;

@Service
public class AreaServiceImp implements AreaService {
	
	@Autowired
	private AreaDAO areaDao;
	
	@Transactional
	@Override
	public List<Area> get() {
		return areaDao.get();
	}

	@Transactional
	@Override
	public List<Area> getAreaId(int id) {
		return areaDao.getAreaId(id);
	}
	
	@Transactional
	@Override
	public List<Area> getAreaName(String areaName){
		return areaDao.getAreaName(areaName);
	}
	
	@Transactional
	@Override
	public List<Area> getAreaStyle(String areaStyle){
		return areaDao.getAreaStyle(areaStyle);
	}

	@Transactional
	@Override
	public void save(Area area) {
		areaDao.save(area);
	}

	@Transactional
	@Override
	public void delete(int id) {
		areaDao.delete(id);
	}	
	
	@Transactional
	@Override
	public List<Area> getAreaCuratorId(String areaCuratorId){
		return areaDao.getAreaCuratorId(areaCuratorId);
	}
}