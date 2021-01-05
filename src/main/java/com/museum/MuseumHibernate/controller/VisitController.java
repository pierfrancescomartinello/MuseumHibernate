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

import com.museum.MuseumHibernate.modal.Visit;
import com.museum.MuseumHibernate.service.VisitService;

@RestController
@RequestMapping("/api")
public class VisitController {
	
	@Autowired
	private VisitService visitService;
	
	@GetMapping("/visit")
	public List<Visit> get() {
		return visitService.get();
	}
	
	@PostMapping("/visit")
	public Visit save(@RequestBody Visit visit) {
		visitService.save(visit);
		return visit;
	}
	
	@GetMapping("/visit/{id}")
		public Visit get(@PathVariable int id) {
			return visitService.get(id);
	}
 
	@DeleteMapping("/visit/{id}")
	public String delete(@PathVariable int id) {
		visitService.delete(id);
		return "Visit removed with id " + id;
	}
	
	@PutMapping("/visit")
	public Visit update(@RequestBody Visit visit) {
		visitService.save(visit);
		return visit;
	}
	
}