package com.museum.MuseumHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.MuseumHibernate.dao.VisitorDAO;
import com.museum.MuseumHibernate.modal.Visitor;

@Service
public class VisitorServiceImp implements VisitorService {
	
	@Autowired
	private VisitorDAO visitorDao;
	
	@Transactional
	@Override
	public List<Visitor> get() {
		return visitorDao.get();
	}

	@Transactional
	@Override
	public Visitor get(int id) {
		return visitorDao.get(id);
	}

	@Transactional
	@Override
	public void save(Visitor visitor) {
		visitorDao.save(visitor);
	}

	@Transactional
	@Override
	public void delete(int id) {
		visitorDao.delete(id);		
	}
	
	@Transactional
	@Override
	public List<Visitor> getName(String name) {
		return visitorDao.getName(name);
	}
	
	@Transactional
	@Override
	public List<Visitor> getSurname(String surname) {
		return visitorDao.getSurname(surname);
	}
	
}