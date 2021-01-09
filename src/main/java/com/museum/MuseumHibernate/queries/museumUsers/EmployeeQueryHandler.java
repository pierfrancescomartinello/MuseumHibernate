package com.museum.MuseumHibernate.queries.museumUsers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.museum.MuseumHibernate.modal.Employee;

public class EmployeeQueryHandler {
	
	//Adds an employee to the database
	public static boolean addEmployeeQuery(String name, String surname, LocalDate dateOfBirth, LocalDate dateOfSignUp, int employeeId, int workingHours, BigDecimal salary, String email){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("INSERT INTO employee (fName, surname, dateOfBirth, dateOfSignUp, employeeID, workingHours, salary, email) " + "VALUES (\""+ name +"\", \""+ surname +"\", \'"+ Date.valueOf(dateOfBirth) +"\', \'"+ Date.valueOf(dateOfSignUp) +"\', "+ employeeId +", "+ workingHours +", "+ salary +", \""+ email +"\")");
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Sets the role of an employee to Curator
	public static boolean modifyCuratorRoleQuery(int employeeId, boolean value){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("UPDATE employee SET isCurator= "+(value==true?1:0)+" WHERE employeeID = " + employeeId);
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Sets the role of an employee to Salesperson
	public static boolean modifySalespersonRoleQuery(int employeeId, boolean value){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("UPDATE employee SET isSalesperson= "+(value==true?1:0)+" WHERE employeeID = " + employeeId);
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Sets the role of an employee to Director
	public static boolean modifyDirectorRoleQuery(int employeeId, boolean value){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("UPDATE employee SET isDirector= "+(value==true?1:0)+" WHERE employeeID = " + employeeId);
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Removes an employee from the database
	public static String deleteEmployeeQuery(int employeeId) {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT email FROM employee WHERE employeeId = " + employeeId + ";");
			String toReturn = rs.getString("email");
			int i = stmn.executeUpdate("DELETE FROM employee WHERE employeeId =" + employeeId + ";");
			
			stmn.close();
			return toReturn;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return "";
		}
	}
	
	//Modifies the salary of an employee
	public static boolean modifyEmployeeSalaryQuery(int employeeId, int newSalary){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("UPDATE emplpoyee SET salary = "+newSalary+"WHERE employeeId = "+employeeId);
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Modifies the workingHours of an employee
	public static boolean modifyEmployeeWorkingHoursQuery(int employeeId, int newWorkingHours){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("UPDATE employee SET WorkingHours = "+newWorkingHours + "WHERE employeeId= " + employeeId);
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
			}
	}
	
	//Shows all the employees
	//To use only on backend level
	public static boolean showAllEmployeesQuery() {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM employee");
			while(rs.next()) {
				String name = rs.getString("fName");
				String surname = rs.getString("surname");
				String dateOfBirth = rs.getString("dateOfBirth");
				String dateOfSignUp = rs.getString("dateOfSignUp");
				String employeeId = rs.getString("employeeId");
				String workingHours = rs.getString("workingHours");
				String salary = rs.getString("salary");
				String email = rs.getString("email");
				String id = rs.getString("employeeId");
				System.out.println(employeeId+" "+name+" - "+surname+" - "+dateOfBirth+" - "+dateOfSignUp+" - "+employeeId+" - "+workingHours+" - "+salary+" - "+email);		
			}	
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Shows all the curators
	//To use only on backend level
	public static boolean showAllCuratorsQuery(){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM employee WHERE isCurator = true");
			while(rs.next()) {
				String eNome = rs.getString("fName");
				String cogeNome = rs.getString("surname");
				System.out.println(eNome + " - " + cogeNome);
			}
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Shows all the salespersons
	//To use only on backend level
	public static boolean showAllSalespersonsQuery(){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM employee WHERE isSalesperson = true");
			while(rs.next()) {
				String eNome = rs.getString("fName");
				String cogeNome = rs.getString("surname");
				System.out.println(eNome + " - " + cogeNome);
			}
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Creates an employee from the database
	public static ArrayList<Employee> employeeQueryDataHandler(){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM employee");
			
			ArrayList<Employee> toReturn = new ArrayList<Employee>();
			
			while(rs.next()) {
				Employee tmp = new Employee(rs.getString("name"), rs.getString("surname"), rs.getInt("workingHours"), rs.getBigDecimal("salary"), rs.getInt("employeeId"));
				toReturn.add(tmp);
			}
			return toReturn;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	//Creates a curator from the database
	public static ArrayList<Employee> CuratorQueryDataHandler() {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM employee WHERE isCurator = true");
			ArrayList<Employee> toReturn = new ArrayList<Employee>();
			while(rs.next()) {
				Employee tmp = new Employee(rs.getString("fName"), rs.getString("surname"), rs.getInt("workingHours"), rs.getBigDecimal("salary"), rs.getInt("employeeId"));
				toReturn.add(tmp);
			}
			return toReturn;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	//Creates a salesperson from the database
	public static ArrayList<Employee> SalespersonQueryDataHandler() {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM employee WHERE isSalesperson = true");
			ArrayList<Employee> toReturn = new ArrayList<Employee>();
			while(rs.next()) {
				Employee tmp = new Employee(rs.getString("fName"), rs.getString("surname"), rs.getInt("workingHours"), rs.getBigDecimal("salary"), rs.getInt("employeeId"));
				toReturn.add(tmp);
			}
			return toReturn;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
}