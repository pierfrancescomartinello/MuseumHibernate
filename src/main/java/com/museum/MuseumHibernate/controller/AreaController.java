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

import com.museum.MuseumHibernate.modal.Area;
import com.museum.MuseumHibernate.service.AreaService;

@RestController
@RequestMapping("/api")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@GetMapping("/area")
	public List<Area> get() {
		return areaService.get();
	}
	
	@PostMapping("/area")
	public Area save(@RequestBody Area area) {
		areaService.save(area);
		return area;
	}
	
	@GetMapping("/area/{id}")
		public Area get(@PathVariable int id) {
			return areaService.get(id);
	}
 
	@DeleteMapping("/area/{id}")
	public String delete(@PathVariable int id) {
		areaService.delete(id);
		return "Area removed with id " + id;
	}
	
	@PutMapping("/area")
	public Area update(@RequestBody Area area) {
		areaService.save(area);
		return area;
	}
	
}