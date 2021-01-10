package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.model.Employee;

public interface EmployeeDAO {
	 List<Employee> get();
	 Employee get(int id);
	 List<Employee> get(String name);
	 List<Employee> getAscWorkingHours();
	 List<Employee> getDescWorkingHours();
	 List<Employee> getWorkingHours(int workingHours);
	 void save(Employee employee);
	 void delete(int id);
}
