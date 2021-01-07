package com.museum.MuseumHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.MuseumHibernate.dao.EmployeeDAO;
import com.museum.MuseumHibernate.modal.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@Transactional
	@Override
	public List<Employee> getAscWorkingHours(){
		return employeeDao.getAscWorkingHours();
	}
	
	@Transactional
	@Override
	public List<Employee> getDescWorkingHours(){
		return employeeDao.getDescWorkingHours();
	}
	
	@Transactional
	@Override
	public List<Employee> get() {
		return employeeDao.get();
	}

	@Transactional
	@Override
	public Employee get(int id) {
		return employeeDao.get(id);
	}
	
	@Transactional
	public List<Employee> get(String name) {
		return employeeDao.get(name);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Transactional
	@Override
	public void delete(int id) {
		employeeDao.delete(id);		
	}
	
	@Transactional
	@Override
	public List<Employee> getWorkingHours(int workingHours){
		return employeeDao.getWorkingHours(workingHours);
	}
}