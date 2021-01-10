package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.model.Employee;
import com.museum.MuseumHibernate.service.EmployeeService;

public interface EmployeeService {
	List<Employee> get();
	Employee get(int id);
	List<Employee> get(String name);
	List<Employee> getWorkingHours(int workingHours);
	List<Employee> getAscWorkingHours();
	List<Employee> getDescWorkingHours();
	void save(Employee artwork);
 	void delete(int id);
}