package com.museum.MuseumHibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.museum.MuseumHibernate.queries.museumSales.TicketQueryHandler;
import com.museum.MuseumHibernate.model.Area;
@RestController
@RequestMapping("/api")
public class VisitController {

	@Autowired
	private AreaController controller;
	
	@GetMapping("/visit/home")
	public ModelAndView viewArea(){
		return new ModelAndView("redirect:/api/area");
	}
	
	/*
	@GetMapping("/visit/visitor={visitor}/useTicket")
	public ModelAndView viewTicket(@PathVariable int visitor) {
		return new ModelAndView("redirect:/api/ticket/visitor={visitor}/usable");
	}
	*/
	
	@GetMapping("/useTicket/ticketId={ticketId}")
	public boolean viewTicket(@PathVariable int ticketId) {
		return TicketQueryHandler.startVisitQuery(ticketId, 0);
	}
	
	@GetMapping("/visit/area={areaId}")
	public ModelAndView viewArea(@PathVariable("areaId") int areaId) {
		return new ModelAndView("redirect:/api/artwork/areaId={areaId}");
	}
	
	@GetMapping("/visit/id={id}")
	public ModelAndView viewArtwork(@PathVariable("id") int id){
		return new ModelAndView("redirect:/api/artwork/{id}");
	}

}
