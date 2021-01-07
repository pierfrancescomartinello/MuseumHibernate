package com.museum.MuseumHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.MuseumHibernate.modal.Employee;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	/* Native query example	
	public List<Employee> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currSession.createNativeQuery("select * from Employee", Employee.class);
		List<Employee> list = query.getResultList();	

		return list;
	}
	*/
	
	@Override
	public List<Employee> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currSession.createQuery("from Employee", Employee.class); 
		List<Employee> list = query.getResultList();	
		
		return list;
	}
	
	@Override
	 public Employee get(int id) {
	  Session currSession = entityManager.unwrap(Session.class);
	  Employee emp = currSession.get(Employee.class, id);
	  return emp;
	 }
	
	 public List<Employee> get(String name) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currSession.createNativeQuery("select * from employee where fName=\"" + name + "\"", Employee.class);
		List<Employee> list = query.getResultList();	

		return list;
	 }
	
	@Override
	public void save(Employee employee) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(employee);
	}
	
	@Override
	 public void delete(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Employee emp = currSession.get(Employee.class, id);
		currSession.delete(emp);
	}
	
	@Override
	public List<Employee> getWorkingHours(int workingHours){
		Session currSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currSession.createNativeQuery("SELECT * FROM employee WHERE workingHours = "+ workingHours +";", Employee.class);
		List<Employee> list = query.getResultList();
		
		return list;
	}
}