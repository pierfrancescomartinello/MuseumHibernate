package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.model.Ticket;

import java.util.Date;

public interface TicketDAO {
	 List<Ticket> get();
	 Ticket get(int id);
 	 List <Ticket> get(String tickettype);
	 List <Ticket> get(Date visitdate);
	 List <Ticket> get(String c, Date purchaseDate);
	 List <Ticket> get(float ticketprice);
	 void save(Ticket ticket);
	 void delete(int id);
	List<Ticket> getUsableTickets(int visitor);
}
