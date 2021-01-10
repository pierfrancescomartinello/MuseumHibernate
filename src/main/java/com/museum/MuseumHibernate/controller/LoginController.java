package com.museum.MuseumHibernate.controller;

import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

import com.museum.MuseumHibernate.modal.Employee;
import com.museum.MuseumHibernate.queries.museumDatabase.AccountQueryHandler;

import java.util.List;

import javax.persistence.EntityManager;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
