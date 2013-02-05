package com.showcase.service;

import java.math.BigInteger;
import java.util.List;

import com.showcase.mongo.domain.Feedback;
import com.showcase.mongo.domain.IMDBMovie;
import com.showcase.mongo.domain.Movie;

public interface MovieService {

	public void insertDataFirstTime();
	public List<Movie> findAllMovies();
	public void addMovie(Movie movie);
	public void deleteMovie(BigInteger id);
	public Movie getMovieById(BigInteger id);
	public void updateMovie(Movie movie, BigInteger id);
	public List<Movie> findByMusicDirector(String musicDirector);
	public List<Movie> findByFlimDirector(String flimDirector);
	public List<Movie> findByTitleLike(String title);
	public List<Movie> findByActorName(String actorName);
	public List<Movie> findByActressName(String actressName);
	
	public void saveFeed(Feedback feedback);
	public List<Feedback> findAllFeeds();
	public void deleteFeedback(BigInteger id);
	
	public IMDBMovie getIMDBMovieByTitle(String searchTitle);
	
}
