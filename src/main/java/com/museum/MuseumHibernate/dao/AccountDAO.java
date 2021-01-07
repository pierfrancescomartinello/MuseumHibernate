package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.modal.Account;

public interface AccountDAO {
	 List<Account> get();
	 Account get(int id);
	 List<Account> get(String email);
	 void save(Account account);
	 void delete(int id);
}
