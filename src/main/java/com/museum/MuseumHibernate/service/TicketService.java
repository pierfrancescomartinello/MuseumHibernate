package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.modal.Ticket;
import com.museum.MuseumHibernate.service.TicketService;

public interface TicketService {
	List<Ticket> get();
	Ticket get(int id);
	void save(Ticket artwork);
 	void delete(int id);
}