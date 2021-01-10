package com.museum.MuseumHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.MuseumHibernate.model.Area;

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
	public List<Area> getAreaId(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Area> query = currSession.createNativeQuery("SELECT * FROM area WHERE areaId = "+ id +";" , Area.class);
		List<Area> list = query.getResultList();
		return list;
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
	
	@Override
	public List<Area> getAreaName(String areaName){
		Session currSession = entityManager.unwrap(Session.class);
		Query<Area> query = currSession.createNativeQuery("SELECT * FROM area WHERE areaName = "+ areaName + ";", Area.class);
		List<Area> list = query.getResultList();
		
		return list;
	}
	
	@Override
	public List<Area> getAreaStyle(String areaStyle){
		Session currSession = entityManager.unwrap(Session.class);
		Query<Area> query = currSession.createNativeQuery("SELECT * FROM area WHERE areaStyle = \"" + areaStyle + ";", Area.class);
		List<Area> list = query.getResultList();
		
		return list;
	}
	
	@Override
	public List<Area> getAreaCuratorId(String areaCuratorId){
		Session currSession = entityManager.unwrap(Session.class);
		Query<Area> query = currSession.createNativeQuery("SELECT * FROM area WHERE areaCuratorId = " + areaCuratorId + ";", Area.class);
		List<Area> list = query.getResultList();
		
		return list;
	}
}