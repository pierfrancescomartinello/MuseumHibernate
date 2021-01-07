package com.museum.MuseumHibernate.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.MuseumHibernate.dao.VisitDAO;
import com.museum.MuseumHibernate.modal.Visit;

@Service
public class VisitServiceImp implements VisitService {
	
	@Autowired
	private VisitDAO visitDao;
	
	@Transactional
	@Override
	public List<Visit> get() {
		return visitDao.get();
	}

	@Transactional
	@Override
	public Visit get(int id) {
		return visitDao.get(id);
	}

	@Transactional
	@Override
	public void save(Visit visit) {
		visitDao.save(visit);
	}

	@Transactional
	@Override
	public void delete(int id) {
		visitDao.delete(id);		
	}
	
	@Transactional
	@Override
	public List<Visit> getAreaName(String areaname) {
		return visitDao.getAreaName(areaname);
	}
	
	@Transactional
	@Override
	public List<Visit> get(Date visitdate) {
		return visitDao.get(visitdate);
	}
	
}