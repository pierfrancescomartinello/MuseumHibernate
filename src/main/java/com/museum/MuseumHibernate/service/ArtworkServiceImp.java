package com.museum.MuseumHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.museum.MuseumHibernate.dao.ArtworkDAO;
import com.museum.MuseumHibernate.modal.Artwork;

@Service
public class ArtworkServiceImp implements ArtworkService {
	
	@Autowired
	private ArtworkDAO artworkDao;
	
	@Transactional
	@Override
	public List<Artwork> get() {
		return artworkDao.get();
	}

	@Transactional
	@Override
	public Artwork get(int id) {
		return artworkDao.get(id);
	}

	@Transactional
	@Override
	public void save(Artwork artwork) {
		artworkDao.save(artwork);
	}

	@Transactional
	@Override
	public void delete(int id) {
		artworkDao.delete(id);		
	}
	
	@Transactional
	@Override
	public List<Artwork> getArtworkName(String artworkName){
		return artworkDao.getArtworkName(artworkName);
	}
	
	@Transactional
	@Override
	public List<Artwork> getArtworkAuthor(String author){
		return artworkDao.getArtworkAuthor(author);
	}
	
	@Transactional
	@Override
	public List<Artwork> getArtworkName(int areaId) {
		return artworkDao.getArtworkName(areaId);
	}
}