package com.museum.MuseumHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.museum.MuseumHibernate.modal.Artwork;

@Repository
public class ArtworkDAOImp implements ArtworkDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Artwork> get() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Artwork> query = currSession.createQuery("from Artwork", Artwork.class); 
		List<Artwork> list = query.getResultList();	

		return list;
	}
	
	@Override
	 public Artwork get(int id) {
	  Session currSession = entityManager.unwrap(Session.class);
	  Artwork emp = currSession.get(Artwork.class, id);
	  return emp;
	 }
	
	@Override
	public void save(Artwork artwork) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(artwork);
	}
	
	@Override
	 public void delete(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Artwork emp = currSession.get(Artwork.class, id);
		currSession.delete(emp);
	}
}