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

import com.museum.MuseumHibernate.modal.Artwork;
import com.museum.MuseumHibernate.service.ArtworkService;

@RestController
@RequestMapping("/api")
public class ArtworkController {
	
	@Autowired
	private ArtworkService artworkService;
	
	@GetMapping("/artwork")
	public List<Artwork> get() {
		return artworkService.get();
	}
	
	@PostMapping("/artwork")
	public Artwork save(@RequestBody Artwork artwork) {
		artworkService.save(artwork);
		return artwork;
	}
	
	@GetMapping("/artwork/{id}")
		public Artwork get(@PathVariable int id) {
			return artworkService.get(id);
	}
 
	@DeleteMapping("/artwork/{id}")
	public String delete(@PathVariable int id) {
		artworkService.delete(id);
		return "Artwork removed with id " + id;
	}
	
	@PutMapping("/artwork")
	public Artwork update(@RequestBody Artwork artwork) {
		artworkService.save(artwork);
		return artwork;
	}
	
}