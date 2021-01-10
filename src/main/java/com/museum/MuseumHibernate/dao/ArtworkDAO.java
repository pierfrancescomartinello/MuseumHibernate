package com.museum.MuseumHibernate.dao;

import java.util.List;

import com.museum.MuseumHibernate.modal.Artwork;

public interface ArtworkDAO {
		List<Artwork> get();
		Artwork get(int id);
		List<Artwork> getArtworkName(String artworkName);
		List<Artwork> getArtworkAuthor(String author);
		void save(Artwork artwork);
		void delete(int id);
		List<Artwork> getArtworkName(int areaId);
}
