package com.museum.MuseumHibernate.modal.Users;
import java.math.*;



public class EmployeeDecorator extends Worker{

	protected Worker specializedEmployee;

	protected EmployeeDecorator() {}
	public EmployeeDecorator(Worker specializedEmployee) {
		super(specializedEmployee.getName(),specializedEmployee.getSurname());
		this.specializedEmployee = specializedEmployee;
	}
	
	public int getEmployeeId(){
	    return this.specializedEmployee.getEmployeeId();
	  }
	public int getWorkingHours(){
    	return this.specializedEmployee.getWorkingHours();
  	}

  	public BigDecimal getSalary(){
    	return this.specializedEmployee.getSalary();
  	}
}
