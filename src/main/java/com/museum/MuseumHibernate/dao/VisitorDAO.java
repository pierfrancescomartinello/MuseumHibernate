package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.model.Visitor;

public interface VisitorDAO {
	 List<Visitor> get();
	 Visitor get(int id);
	 void save(Visitor visitor);
	 void delete(int id);
	 List<Visitor> getName(String name);
	 List<Visitor> getSurname(String surname);
	 List<Visitor> getEmail(String email);
}

