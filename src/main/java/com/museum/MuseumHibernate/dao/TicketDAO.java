package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.modal.Ticket;

public interface TicketDAO {
	 List<Ticket> get();
	 Ticket get(int id);
	 void save(Ticket ticket);
	 void delete(int id);
}
