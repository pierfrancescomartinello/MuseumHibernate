package com.museum.MuseumHibernate.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visitor")
public class Visitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="visitorid")
	private Integer visitorId;

	@Column(name="fname")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="dateofbirth")
	private Date dateOfBirth;
	
	@Column(name="dateofsignup")
	private Date dateOfSignUp;
	
	@Column(name="email")
	private String email;

	public Integer getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfSignUp() {
		return dateOfSignUp;
	}

	public void setDateOfSignUp(Date dateOfSignUp) {
		this.dateOfSignUp = dateOfSignUp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}