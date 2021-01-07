package com.museum.MuseumHibernate.dao;

import java.util.List;
import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.MuseumHibernate.modal.Employee;
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
	
	@Override
	public List<Ticket> get(String tickettype) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Ticket> query = currSession.createNativeQuery("select * from Ticket where tickettype=\"" + tickettype + "\"", Ticket.class);
		List<Ticket> list= query.getResultList();
		return list;
	}
	
	@Override
	public List<Ticket> get(float ticketprice) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Ticket> query = currSession.createNativeQuery("select * from Ticket where ticketprice=\"" + ticketprice + "\"", Ticket.class);
		List<Ticket> list= query.getResultList();
		return list;
	}
	
	@Override
	public List<Ticket> get(Date visitdate) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Ticket> query = currSession.createNativeQuery("select * from Ticket where visitdate=\"" + visitdate + "\"", Ticket.class);
		List<Ticket> list= query.getResultList();
		return list;
	}
	
	@Override
	public List<Ticket> get(String c,Date purchaseDate) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Ticket> query = currSession.createNativeQuery("select * from Ticket where purchaseDate=\"" + purchaseDate + "\"", Ticket.class);
		List<Ticket> list= query.getResultList();
		return list;
	}
}