package com.museum.MuseumHibernate.service;

import java.util.List;

import com.museum.MuseumHibernate.modal.Artwork;
import com.museum.MuseumHibernate.service.ArtworkService;

public interface ArtworkService {
	List<Artwork> get();
	Artwork get(int id);
	void save(Artwork artwork);
 	void delete(int id);
}