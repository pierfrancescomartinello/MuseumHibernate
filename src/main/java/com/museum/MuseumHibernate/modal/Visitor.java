package com.museum.MuseumHibernate.modal;

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
	
	public Visitor(){
		
	}
	
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
	
	/*
		public void signUp(String name, String surname, LocalDate dateOfBirth, LocalDate dateOfSignUp, boolean isAdult, int visitorId, String email, String password, String confirmPassword) throws ClassNotFoundException {
		if(email.matches("[[a-z]&&[_-.,]+&&[0-9++]+@[a-z]+.[a-z]+")) {
			if(password.equals(confirmPassword))
				VisitorQueryHandler.addVisitorQuery(name, surname, dateOfBirth, dateOfSignUp, isAdult, visitorId, email);
				AccountQueryHandler.addAccountQuery(email, password);
		}
	}

	public boolean buyTicket(String ticketType, LocalDate visitDate, BigDecimal ticketPrice, int visitorId) {
		TicketQueryHandler.addTicketQuery(ticketType, visitDate, true, ticketPrice, visitorId);
		return true;
	}

	
	public boolean deleteTicket(Ticket ticket) {
		return true;
	}

	public boolean showTickets() {
		TicketQueryHandler.showTicketsQuery(this.getVisitorId());
		return true;
	}

	public boolean buyGadget() {
		return true;
	}

	public boolean feedback(String feedback) {
		return true;
	}

	public boolean startVisit(int ticketId) {
		return true;
	}

	public int getVisitorId() {
		return this.visitorId;
	}
	*/

	
}