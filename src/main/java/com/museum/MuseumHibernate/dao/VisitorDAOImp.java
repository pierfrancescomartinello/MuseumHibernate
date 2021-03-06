package com.museum.MuseumHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.MuseumHibernate.model.Visitor;

@Repository
public class VisitorDAOImp implements VisitorDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Visitor> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Visitor> query = currSession.createQuery("from Visitor", Visitor.class); 
		List<Visitor> list = query.getResultList();	

		return list;
	}
	
	@Override
	 public Visitor get(int id) {
	  Session currSession = entityManager.unwrap(Session.class);
	  Visitor emp = currSession.get(Visitor.class, id);
	  return emp;
	 }
	
	@Override
	public void save(Visitor visitor) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(visitor);
	}
	
	@Override
	 public void delete(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Visitor emp = currSession.get(Visitor.class, id);
		currSession.delete(emp);
	}
	
	@Override
	public List<Visitor> getName(String name) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Visitor> query = currSession.createNativeQuery("select * from Ticket where fName=\"" + name + "\"", Visitor.class);
		List<Visitor> list= query.getResultList();
		return list;
	}
	
	@Override
	public List<Visitor> getSurname(String surname) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Visitor> query = currSession.createNativeQuery("select * from Ticket where surname=\"" + surname + "\"", Visitor.class);
		List<Visitor> list= query.getResultList();
		return list;
	}

	@Override
	public List<Visitor> getEmail(String email) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Visitor> query = currSession.createNativeQuery("select * from Visitor where email=\"" + email + "\"", Visitor.class);
		List<Visitor> list= query.getResultList();
		return list;
	}
	
	
}