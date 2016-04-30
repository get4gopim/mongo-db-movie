package com.showcase.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.showcase.service.movies.MovieService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:test-app-context.xml" })
public class TestMovieService {
	
	@Autowired
	private MovieService movieService;
	
	@Test
	public void test() {
		movieService.findAllMovies();
	}

}
