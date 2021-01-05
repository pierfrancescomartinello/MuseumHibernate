package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.modal.Artwork;

public interface ArtworkDAO {
	 List<Artwork> get();
	 Artwork get(int id);
	 void save(Artwork artwork);
	 void delete(int id);
}
