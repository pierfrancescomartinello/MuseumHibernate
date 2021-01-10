package com.museum.MuseumHibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.museum.MuseumHibernate.model.Account;
import com.museum.MuseumHibernate.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account")
	public List<Account> get() {
		return accountService.get();
	}
	
	@PostMapping("/account")
	public Account save(@RequestBody Account account) {
		accountService.save(account);
		return account;
	}
	
	@GetMapping("/account/{id}")
		public Account get(@PathVariable int id) {
			return accountService.get(id);
	}
 
	@DeleteMapping("/account/{id}")
	public String delete(@PathVariable int id) {
		accountService.delete(id);
		return "Account removed with id " + id;
	}
	
	@PutMapping("/account")
	public Account update(@RequestBody Account account) {
		accountService.save(account);
		return account;
	}
	
	@GetMapping("/account/email={email}")
    public List<Account> get(@PathVariable String email) {
        return accountService.get(email);	
    }

  
	
}