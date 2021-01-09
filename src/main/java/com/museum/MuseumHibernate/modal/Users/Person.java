package com.museum.MuseumHibernate.modal.Users;

import java.time.LocalDate;
import java.time.Month;

import com.museum.MuseumHibernate.queries.museumDatabase.AccountQueryHandler;
import com.museum.MuseumHibernate.util.Utilities;

public abstract class Person{

	private String name;
	private String surname;
	private LocalDate dateOfBirth;
	private LocalDate dateOfSignUp;
	private boolean isAdult;
	private String email;

	//Da usare soltanto perche serve a JPA per il collegamento al DB
	protected Person() {}

	public Person(String name, String surname){
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(int dd, Month MMM, int yyyy) {
		this.dateOfBirth = Utilities.LocalDateCreator(dd, MMM, yyyy);
	}

	public LocalDate getDateOfSignUp() {
		return this.dateOfSignUp;
	}

	public void setDateOfSignUp(int dd, Month MMM, int yyyy) {
		this.dateOfSignUp = LocalDate.now();
	}

	public boolean isAdult() {
		return this.isAdult;
	}

	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}
	
	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*public void modifyEmail(String email){
		if(this.isLoggedIn == true)
			this.email = email;
		else
			System.out.println("Not logged in");
	}*/
	
	public void modifyPassword(String email, String oldPassword, String newPassword){
		if(oldPassword.equals(AccountQueryHandler.getPasswordQuery(email))){
			if(!newPassword.equals(""))
				System.out.println("New password set");
			else
				System.out.println("New password is missing");
		}
		else
			System.out.println("Old password isn't matching");
	}

	public static boolean logIn(String email, String password){
		if(password.equals(AccountQueryHandler.getPasswordQuery(email))){
			return AccountQueryHandler.modifyIsLoggedInStateQuery(email, 1);
		}
		return false;
	}
	

	public static void logOut(String email){
		AccountQueryHandler.modifyIsLoggedInStateQuery(email, 0);
	}
}
