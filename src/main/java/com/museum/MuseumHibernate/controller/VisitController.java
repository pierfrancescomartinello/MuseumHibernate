package com.museum.MuseumHibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.museum.MuseumHibernate.queries.museumSales.TicketQueryHandler;

@RestController
@RequestMapping("/api")
public class VisitController {

	@GetMapping("/visit/home")
	public String viewArea(){
		return "redirect:api/area";
	}
	
	@GetMapping("/visit/visitor={visitor}/useTicket")
	public String viewTicket(@PathVariable int visitor) {
		return "redirect:/api/ticket/visitor={visitor}/usable";
	}
	
	@PostMapping("/visit/visitor={visitor}/useTicket/ticketId={ticketId}")
	public boolean viewTicket(@PathVariable int visitor, @PathVariable int ticketId) {
		return TicketQueryHandler.startVisitQuery(ticketId, visitor);
	}
	
	@GetMapping("/visit/area={areaId}")
	public String viewArea(@PathVariable("areaId") int areaId) {
		return "redirect:api/artwork/areaId={areaId}";
	}
	
	@GetMapping("/visit/id={id}")
	public String viewArtwork(@PathVariable("id") int id){
		return "redirect:api/artwork/{id}";
	}

}
