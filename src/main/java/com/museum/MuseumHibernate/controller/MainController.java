package com.museum.MuseumHibernate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.museum.MuseumHibernate.modal.Area;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@GetMapping("/main")
	public List<String> get() {
		ArrayList<String> l = new ArrayList<>();
		l.add("Ciao");
		l.add("Mi chiamo Ruix");
		return l;
	}
}
