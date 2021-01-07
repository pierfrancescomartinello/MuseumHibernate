package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.modal.Employee;

public interface EmployeeDAO {
	 List<Employee> get();
	 Employee get(int id);
	 List<Employee> get(String name);
	 List<Employee> getWorkingHours(int workingHours);
	 void save(Employee employee);
	 void delete(int id);
}
