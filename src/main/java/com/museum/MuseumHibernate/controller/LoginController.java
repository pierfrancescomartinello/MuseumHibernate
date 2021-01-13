package com.museum.MuseumHibernate.controller;

import org.springframework.web.bind.annotation.RestController;

import com.museum.MuseumHibernate.model.Employee;
import com.museum.MuseumHibernate.model.Ticket;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("")
public class LoginController {
	
	@Autowired
	private EntityManager entityManager;
	
	/*
	@RequestMapping(value = "/login", headers = {"email=email" , "password=password"}, method = RequestMethod.POST)
	@ResponseBody
	public List<String> loginQuery(@PathVariable("email") String email, @PathVariable("password") String password) throws UnsupportedEncodingException{
		String queryEmail = URLDecoder.decode(email, "utf8");
		if (AccountQueryHandler.checkEmailQuery(queryEmail)){
			if (AccountQueryHandler.getPasswordQuery(queryEmail).equals(password)){
					AccountQueryHandler.modifyIsLoggedInStateQuery(queryEmail, 1);
			}
		}
		
		List<String> we = new ArrayList<String>();
		return we;
	}
	*/
	
	/* LOGIN QUERIES */
	
	@GetMapping("/login")
	public @ResponseBody boolean loginQuery (@RequestParam("email") String email, @RequestParam("password") String password) throws UnsupportedEncodingException {
		/*String email = "we";
		String password = "we";*/
		
		Session currSession = entityManager.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		Query<String> query = currSession.createNativeQuery(
				"SELECT password from account "
				+ "WHERE email = \"" + email +"\" and password = \"" + password+ "\"");
		List<String> list = query.getResultList();
		
		if ((list.size()) == 1)
			return true;
		return false;
	}
	
	// useful to get a visitorId relative to a certain email. 
	@GetMapping("/login/visitorId")
	public @ResponseBody List<Integer> visitorIdQuery (@RequestParam("email") String email) {
		/*String email = "we";
		String password = "we";*/
		
		Session currSession = entityManager.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		Query<Integer> query = currSession.createNativeQuery(
				"SELECT visitorid FROM account, visitor "
				+ "WHERE account.email = visitor.email and account.email=\'" + email + "'");
		List<Integer> list = query.getResultList();
		
		if ((list.size()) == 1)
			return list;
		return null;
	}
	
	@GetMapping("/login/userInfo/name")
	public @ResponseBody List<String> userInfoQueryName (@RequestParam("email") String email) {
		Session currSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<String> query = currSession.createNativeQuery(
				"SELECT fName "
				+ "FROM account, visitor "
				+ "WHERE account.email = visitor.email and account.email=\'" + email + "'");
		
		List<String> list = query.getResultList();
		
		if ((list.size()) == 1)
			return list;
		return null;
	}
	
	@GetMapping("/login/userInfo/surname")
	public @ResponseBody List<String> userInfoQuerySurname (@RequestParam("email") String email) {
		Session currSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<String> query = currSession.createNativeQuery(
				"SELECT surname "
				+ "FROM account, visitor "
				+ "WHERE account.email = visitor.email and account.email=\'" + email + "'");
		
		List<String> list = query.getResultList();
		
		if ((list.size()) == 1)
			return list;
		return null;
	}
	
	@GetMapping("/login/userInfo/visitorId")
	public @ResponseBody List<Integer> userInfoQueryVisitorId (@RequestParam("email") String email) {
		Session currSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<Integer> query = currSession.createNativeQuery(
				"SELECT visitorId "
				+ "FROM account, visitor "
				+ "WHERE account.email = visitor.email and account.email=\'" + email + "'");
		
		List<Integer> list = query.getResultList();
		
		if ((list.size()) == 1)
			return list;
		return null;
	}
	
	/* TICKET QUERIES */
	@GetMapping("/login/tickets")
	public @ResponseBody List<Ticket> ticketInfoQuery (@RequestParam("visitorId") int visitorId) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Ticket> query = currSession.createQuery("from Ticket where visitor = " + visitorId, Ticket.class); 
		List<Ticket> list = query.getResultList();	
		
		return list;
	}
	
	/* QUERY DE JESUS */
	@GetMapping("/login/ticketInfo/ticketOf")
	public @ResponseBody List<Ticket> ticketOf (@RequestParam("email") String email) {
		Session currSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<Ticket> query = currSession.createNativeQuery(
				"select purchaseDate, visitDate, ticketType, ticketPrice, isUsable, visitor, ticketId from account, visitor, ticket \r\n"
				+ "where account.email = visitor.email and visitor.visitorId = ticket.visitor and account.email = \"" + email + "\"");
		
		List<Ticket> list = query.getResultList();
		
		return list;
	}
	
	
	@GetMapping("/login/ticketInfo/purchaseDate")
	public @ResponseBody List<Date> ticketInfoQueryPurchaseDate (@RequestParam("visitorId") int visitorId) {
		Session currSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<Date> query = currSession.createNativeQuery(
				"SELECT purchaseDate "
				+ "FROM ticket "
				+ "WHERE visitor =" + visitorId);
		
		List<Date> list = query.getResultList();
		
		return list;
	}
	
	@GetMapping("/login/ticketInfo/visitDate")
	public @ResponseBody List<Date> ticketInfoQueryVisitDate (@RequestParam("visitorId") int visitorId) {
		Session currSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<Date> query = currSession.createNativeQuery(
				"SELECT visitDate "
				+ "FROM ticket "
				+ "WHERE visitor =" + visitorId);
		
		List<Date> list = query.getResultList();
		
		return list;
	}
	
	@GetMapping("/login/ticketInfo/ticketType")
	public @ResponseBody List<String> ticketInfoQueryTicketType (@RequestParam("visitorId") int visitorId) {
		Session currSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<String> query = currSession.createNativeQuery(
				"SELECT ticketType "
				+ "FROM ticket "
				+ "WHERE visitor =" + visitorId);
		
		List<String> list = query.getResultList();
		
		return list;
	}
	
	@GetMapping("/login/ticketInfo/ticketPrice")
	public @ResponseBody List<Float> ticketInfoQueryTicketPrice (@RequestParam("visitorId") int visitorId) {
		Session currSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<Float> query = currSession.createNativeQuery(
				"SELECT ticketPrice "
				+ "FROM ticket "
				+ "WHERE visitor =" + visitorId);
		
		List<Float> list = query.getResultList();
		
		return list;
	}
	
	@GetMapping("/login/ticketInfo/isUsable")
	public @ResponseBody List<Boolean> ticketInfoQueryTicketIsUsable (@RequestParam("visitorId") int visitorId) {
		Session currSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<Boolean> query = currSession.createNativeQuery(
				"SELECT isusable "
				+ "FROM ticket "
				+ "WHERE visitor =" + visitorId);
		
		List<Boolean> list = query.getResultList();
		
		return list;
	}
}
