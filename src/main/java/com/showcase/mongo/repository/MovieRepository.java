package com.showcase.mongo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.showcase.mongo.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, BigInteger> {

	List<Movie> findByTitle(String title);
	
	List<Movie> findByMusicDirector(String musicDirector);
	
	List<Movie> findByFlimDirector(String flimDirector);
	
	List<Movie> findByActorName(String actorName);
	
	List<Movie> findByActressName(String actressName);
	
	List<Movie> findByReleaseYear(int year);
	
	List<Movie> findByMusicDirectorAndFlimDirector(String musicDirector, String flimDirector);
	
	List<Movie> findByTitleLike(String title);
	
}
