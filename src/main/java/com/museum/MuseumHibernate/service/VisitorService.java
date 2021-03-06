package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.model.Visitor;
import com.museum.MuseumHibernate.service.VisitorService;

public interface VisitorService {
	List<Visitor> get();
	Visitor get(int id);
	List<Visitor> getName(String name);
	List<Visitor> getSurname(String surname);
	void save(Visitor artwork);
 	void delete(int id);
	List<Visitor> getEmail(String email);
}