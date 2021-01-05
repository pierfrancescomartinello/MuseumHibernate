package com.museum.MuseumHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.MuseumHibernate.dao.AccountDAO;
import com.museum.MuseumHibernate.modal.Account;

@Service
public class AccountServiceImp implements AccountService {
	
	@Autowired
	private AccountDAO accountDao;
	
	@Transactional
	@Override
	public List<Account> get() {
		return accountDao.get();
	}

	@Transactional
	@Override
	public Account get(int id) {
		return accountDao.get(id);
	}

	@Transactional
	@Override
	public void save(Account account) {
		accountDao.save(account);
	}

	@Transactional
	@Override
	public void delete(int id) {
		accountDao.delete(id);		
	}
	
}