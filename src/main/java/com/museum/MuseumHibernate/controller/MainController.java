package com.museum.MuseumHibernate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.museum.MuseumHibernate.model.Employee;
import com.museum.MuseumHibernate.queries.museumUsers.EmployeeQueryHandler;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@GetMapping("/main")
	public List<Employee> get() {
		List<Employee> l = EmployeeQueryHandler.employeeQueryDataHandler();
		return l;
	}
	
	@GetMapping("/mainmeglio")
	public List<Employee> getWe() {
		List<Employee> l = EmployeeQueryHandler.employeeQueryDataHandler();
		return l;
	}
} 
