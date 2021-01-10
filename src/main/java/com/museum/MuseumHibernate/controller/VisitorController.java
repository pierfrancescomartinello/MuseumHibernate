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

import com.museum.MuseumHibernate.model.Visitor;
import com.museum.MuseumHibernate.service.VisitorService;

@RestController
@RequestMapping("/api")
public class VisitorController {
	
	@Autowired
	private VisitorService visitorService;
	
	@GetMapping("/visitor")
	public List<Visitor> get() {
		return visitorService.get();
	}
	
	@PostMapping("/visitor")
	public Visitor save(@RequestBody Visitor visitor) {
		visitorService.save(visitor);
		return visitor;
	}
	
	@GetMapping("/visitor/{id}")
		public Visitor get(@PathVariable int id) {
			return visitorService.get(id);
	}
 
	@DeleteMapping("/visitor/{id}")
	public String delete(@PathVariable int id) {
		visitorService.delete(id);
		return "Visitor removed with id " + id;
	}
	
	@PutMapping("/visitor")
	public Visitor update(@RequestBody Visitor visitor) {
		visitorService.save(visitor);
		return visitor;
	}
	
	
	@GetMapping("/visitor/name={name}")
		public List<Visitor> getName(@PathVariable String name) {
			return visitorService.getName(name);
	}
	
	@GetMapping("/visitor/surname={surname}")
	public List<Visitor> getSurname(@PathVariable String surname) {
		return visitorService.getSurname(surname);
	}
	
	@GetMapping("/visitor/email={email}")
	public List<Visitor> getEmail(@PathVariable String email) {
		return visitorService.getEmail(email);
}
	
}