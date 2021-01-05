package com.museum.MuseumHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.MuseumHibernate.modal.Ticket;

@Repository
public class TicketDAOImp implements TicketDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Ticket> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Ticket> query = currSession.createQuery("from Ticket", Ticket.class); 
		List<Ticket> list = query.getResultList();	

		return list;
	}
	
	@Override
	 public Ticket get(int id) {
	  Session currSession = entityManager.unwrap(Session.class);
	  Ticket emp = currSession.get(Ticket.class, id);
	  return emp;
	 }
	
	@Override
	public void save(Ticket ticket) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(ticket);
	}
	
	@Override
	 public void delete(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Ticket emp = currSession.get(Ticket.class, id);
		currSession.delete(emp);
	}
}