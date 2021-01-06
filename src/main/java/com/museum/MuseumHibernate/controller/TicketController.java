package com.museum.MuseumHibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.museum.MuseumHibernate.modal.Ticket;
import com.museum.MuseumHibernate.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/ticket")
	public List<Ticket> get() {
		return ticketService.get();
	}
	
	@PostMapping("/ticket")
	public Ticket save(@RequestBody Ticket ticket) {
		ticketService.save(ticket);
		return ticket;
	}
	
	@GetMapping("/ticket/{id}")
		public Ticket get(@PathVariable int id) {
			return ticketService.get(id);
	}
 
	@DeleteMapping("/ticket/{id}")
	public String delete(@PathVariable int id) {
		ticketService.delete(id);
		return "Ticket removed with id " + id;
	}
	
	@PutMapping("/ticket")
	public Ticket update(@RequestBody Ticket ticket) {
		ticketService.save(ticket);
		return ticket;
	}
	
}