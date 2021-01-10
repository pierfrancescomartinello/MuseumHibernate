package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.model.Account;
import com.museum.MuseumHibernate.service.AccountService;

public interface AccountService {
	List<Account> get();
	Account get(int id);
	List<Account> get (String email);
	void save(Account artwork);
 	void delete(int id);
}