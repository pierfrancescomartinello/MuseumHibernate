package com.museum.MuseumHibernate.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	public Employee() {
		
	}
	
	public Employee(String string, String string2, int int1, BigDecimal bigDecimal, int int2) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employeeid")
	public int employeeId;
	
	@Column(name="fname")
	public String name;
	
	@Column(name="surname")
	public String surname;
	
	@Column(name="dateofbirth")
	public Date dob;
	
	@Column(name="dateofsignup")
	public Date dateOfSignup;
	
	@Column(name="iscurator")
	public boolean isCurator;
	
	@Column(name="isdirector")
	public boolean isDirector;
	
	@Column(name="issalesperson")
	public boolean isSalesperson;
	
	private float salary;
	
	@Column(name="workinghours")
	public int workingHours;
	
	@Column(name="email")
	public String email;
	
	@Column(name="salary")
	public float getSalary() {
		return salary;
	}
	
}