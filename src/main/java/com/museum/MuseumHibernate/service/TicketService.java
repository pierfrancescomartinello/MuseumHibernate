package com.museum.MuseumHibernate.service;

import java.util.List;
import java.util.Date;

import com.museum.MuseumHibernate.model.Ticket;
import com.museum.MuseumHibernate.service.TicketService;

public interface TicketService {
	List<Ticket> get();
	Ticket get(int id);
	List<Ticket> get(String tickettype);
	List<Ticket> get(Date visitdate);
    List <Ticket> get(String c, Date purchaseDate);
	List <Ticket> get(float ticketprice);
	void save(Ticket artwork);
 	void delete(int id);
	List<Ticket> getUsableTickets(int visitor);
}