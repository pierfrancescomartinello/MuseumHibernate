package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.model.Artwork;
import com.museum.MuseumHibernate.service.ArtworkService;

public interface ArtworkService {
	List<Artwork> get();
	Artwork get(int id);
	List<Artwork> getArtworkName(String artworkName);
	List<Artwork> getArtworkName(int areaId);
	void save(Artwork artwork);
 	void delete(int id);	
	List<Artwork> getArtworkAuthor(String artworkName);
}