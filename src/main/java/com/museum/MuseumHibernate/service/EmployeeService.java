package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.modal.Employee;
import com.museum.MuseumHibernate.service.EmployeeService;

public interface EmployeeService {
	List<Employee> get();
	Employee get(int id);
	List<Employee>get(String name);
	void save(Employee artwork);
 	void delete(int id);
}