package com.museum.MuseumHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.MuseumHibernate.modal.Area;

@Repository
public class AreaDAOImp implements AreaDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Area> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Area> query = currSession.createQuery("from Area", Area.class); 
		List<Area> list = query.getResultList();	

		return list;
	}
	
	@Override
	 public Area get(int id) {
	  Session currSession = entityManager.unwrap(Session.class);
	  Area emp = currSession.get(Area.class, id);
	  return emp;
	 }
	
	@Override
	public void save(Area area) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(area);
	}
	
	@Override
	 public void delete(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Area emp = currSession.get(Area.class, id);
		currSession.delete(emp);
	}
}