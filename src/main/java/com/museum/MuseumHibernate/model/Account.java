package com.museum.MuseumHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
		
	public Account() {
		
	}
	
	@Id
	@Column(name = "email")
	public String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="isloggedin")
	private String accountIsLoggedIn;

	public Account(String string, String generateHiddenPassword, boolean boolean1) {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsLoggedIn() {
		return accountIsLoggedIn;
	}

	public void setIsLoggedIn(String accountIsLoggedIn) {
		this.accountIsLoggedIn = accountIsLoggedIn;
	}

}