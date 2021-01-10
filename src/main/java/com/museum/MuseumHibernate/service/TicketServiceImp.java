package com.museum.MuseumHibernate.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.MuseumHibernate.dao.TicketDAO;
import com.museum.MuseumHibernate.model.Ticket;

@Service
public class TicketServiceImp implements TicketService {
	
	@Autowired
	private TicketDAO ticketDao;
	
	@Transactional
	@Override
	public List<Ticket> get() {
		return ticketDao.get();
	}

	@Transactional
	@Override
	public Ticket get(int id) {
		return ticketDao.get(id);
	}

	@Transactional
	@Override
	public void save(Ticket ticket) {
		ticketDao.save(ticket);
	}

	@Transactional
	@Override
	public void delete(int id) {
		ticketDao.delete(id);		
	}
	@Transactional
	@Override
	public List<Ticket> get(String tickettype) {
		return ticketDao.get(tickettype);
	}
	
	@Transactional
	@Override
	public List<Ticket> get(float ticketprice) {
		return ticketDao.get(ticketprice);
	}
	
	@Transactional
	@Override
	public List<Ticket> get(Date visitdate) {
		return ticketDao.get(visitdate);
	}
	
	@Transactional
	@Override
	public List<Ticket> get(String c, Date purchaseDate) {
		return ticketDao.get(purchaseDate);
	}
		
	@Transactional
	@Override
	public List<Ticket> getUsableTickets(int visitor) {
		return ticketDao.getUsableTickets(visitor);
	}
	
}