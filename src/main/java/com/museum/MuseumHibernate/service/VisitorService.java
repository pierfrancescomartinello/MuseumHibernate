package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.modal.Visitor;
import com.museum.MuseumHibernate.service.VisitorService;

public interface VisitorService {
	List<Visitor> get();
	Visitor get(int id);
	void save(Visitor artwork);
 	void delete(int id);
}