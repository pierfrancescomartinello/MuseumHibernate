package com.museum.MuseumHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.MuseumHibernate.modal.Visit;

@Repository
public class VisitDAOImp implements VisitDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Visit> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Visit> query = currSession.createQuery("from Visit", Visit.class); 
		List<Visit> list = query.getResultList();	

		return list;
	}
	
	@Override
	 public Visit get(int id) {
	  Session currSession = entityManager.unwrap(Session.class);
	  Visit emp = currSession.get(Visit.class, id);
	  return emp;
	 }
	
	@Override
	public void save(Visit visit) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(visit);
	}
	
	@Override
	 public void delete(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Visit emp = currSession.get(Visit.class, id);
		currSession.delete(emp);
	}
}