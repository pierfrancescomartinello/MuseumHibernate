package com.museum.MuseumHibernate.modal.Users;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Salesperson extends EmployeeDecorator{
	
	public Salesperson() {}
	
	public Salesperson(Worker specializedEmployee) {
		super(specializedEmployee);
	}
}
