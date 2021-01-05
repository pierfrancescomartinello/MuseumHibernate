package com.museum.MuseumHibernate.modal.Users;

import java.util.ArrayList;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDate;

import com.museum.MuseumHibernate.modal.Employee;
import com.museum.MuseumHibernate.queries.museumDatabase.AccountQueryHandler;
import com.museum.MuseumHibernate.queries.museumUsers.EmployeeQueryHandler;
import com.museum.MuseumHibernate.util.Utilities;

public class Director extends EmployeeDecorator{

	protected Director() {}
	
	public Director(Worker specializedEmployee) {
		super(specializedEmployee);
	}
	
	//Director assumes an employee
	public void addEmployee(String name, String surname, LocalDate dateOfBirth, int employeeId, int workingHours, BigDecimal salary, String email) throws ClassNotFoundException{
		AccountQueryHandler.addAccountQuery(email, Utilities.generatePassword());
		EmployeeQueryHandler.addEmployeeQuery(name, surname, dateOfBirth, LocalDate.now(), employeeId, workingHours, salary, email);
	}
	
	//Director fires an employee
	public void dismissEmployee(int employeeId){
		String email = EmployeeQueryHandler.deleteEmployeeQuery(employeeId);
		AccountQueryHandler.deleteAccountQuery(email);
		
	}
	
	//Shows all the employees
	public ArrayList<Employee> showAllEmployees(){
		return EmployeeQueryHandler.EmployeeQueryDataHandler();
	}
	
	//Shows all the curators
	public ArrayList<Employee> showCurators(){
		return EmployeeQueryHandler.CuratorQueryDataHandler();
	}
	
	//Shows all the salespersons
	public ArrayList<Employee> showSalespersons(){
		return EmployeeQueryHandler.SalespersonQueryDataHandler();
	}
	
	//Director promotes an employee to curator
	public boolean promoteToCurator(int employeeId){
		return EmployeeQueryHandler.modifyCuratorRoleQuery(employeeId, true);
	}
	
	//Director promotes an employee to salesperson
	public boolean promoteToSalesPerson(int employeeId){
		return EmployeeQueryHandler.modifySalespersonRoleQuery(employeeId, true);
	}
	
	//Director promotes an employee to director
	public boolean promoteToDirector(int employeeId){
		 return EmployeeQueryHandler.modifyDirectorRoleQuery(employeeId, true);
	}
	
	//Director downgrades a curator
	public boolean downgradeCurator(int employeeId){
		return EmployeeQueryHandler.modifyCuratorRoleQuery(employeeId, false);
	}
	
	//Director downgrades a salesperson
	public boolean downgradeSalesperson(int employeeId){
		return EmployeeQueryHandler.modifySalespersonRoleQuery(employeeId, false);
	}
	
	//Director downgrades a director
	public boolean downgradeDirector(int employeeId){
		return EmployeeQueryHandler.modifyDirectorRoleQuery(employeeId, false);
	}
}