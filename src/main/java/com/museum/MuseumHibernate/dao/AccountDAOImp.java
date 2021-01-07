package com.museum.MuseumHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.MuseumHibernate.modal.Account;
import com.museum.MuseumHibernate.modal.Employee;

@Repository
public class AccountDAOImp implements AccountDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Account> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Account> query = currSession.createQuery("from Account", Account.class); 
		List<Account> list = query.getResultList();	

		return list;
	}
	
	@Override
	public Account get(int id) {
	  Session currSession = entityManager.unwrap(Session.class);
	  Account emp = currSession.get(Account.class, id);
	  return emp;
	 }
		
	@Override
	public void save(Account account) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(account);
	}
	
	@Override
	 public void delete(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Account emp = currSession.get(Account.class, id);
		currSession.delete(emp);
	}

	@Override
	public List<Account> get(String email) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Account> query = currSession.createNativeQuery("select * from account where email=\"" + email + "\"", Account.class);
		List<Account> list = query.getResultList();	

		return list;
	}
}