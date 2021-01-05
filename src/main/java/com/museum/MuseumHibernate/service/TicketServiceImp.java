package com.museum.MuseumHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.MuseumHibernate.dao.TicketDAO;
import com.museum.MuseumHibernate.modal.Ticket;

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
	
}