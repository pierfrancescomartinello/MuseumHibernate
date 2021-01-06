package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.modal.Visitor;

public interface VisitorDAO {
	 List<Visitor> get();
	 Visitor get(int id);
	 void save(Visitor visitor);
	 void delete(int id);
}