package com.museum.MuseumHibernate.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
public class HomeController {
	
	private String presentationMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum quis arcu lacus." + 
										 "Fusce lobortis, purus eu luctus vehicula, lacus mauris lobortis justo, at facilisis diam augue ut nisl. " +
										 "Phasellus nunc nisi, pellentesque eu dolor et, aliquam accumsan lectus. Maecenas viverra risus id facilisis aliquet. " +
										 "Cras finibus consectetur fringilla. Integer at lectus non lacus dictum consectetur." +
										 "Nam vehicula libero ex, sit amet efficitur odio sollicitudin in. ";

	@RequestMapping("/WAW")
	public String whoAreWe(){
		return presentationMessage;
	}
	
}
