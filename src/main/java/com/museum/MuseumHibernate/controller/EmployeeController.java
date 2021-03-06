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

import com.museum.MuseumHibernate.model.Employee;
import com.museum.MuseumHibernate.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> get() {
		return employeeService.get();
	}
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@GetMapping("/employee/{id}")
		public Employee get(@PathVariable int id) {
			return employeeService.get(id);
	}
	
	@GetMapping("/employee/name={name}")
	public List<Employee> get(@PathVariable String name) {
		return employeeService.get(name);
	}
 	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeeService.delete(id);
		return "Employee removed with id " + id;
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@GetMapping("/employee/workingHours={workingHours}")
	public List<Employee> getWorkingHours(int workingHours){
		return employeeService.getWorkingHours(workingHours);
	}
	
	@GetMapping("/employee/workingHours/asc")
	public List<Employee> getAscWorkingHours(){
		return employeeService.getAscWorkingHours();
	}
	
	@GetMapping("/employee/workingHours/des")
	public List<Employee> getDescWorkingHours(){
		return employeeService.getDescWorkingHours();	
	}
}