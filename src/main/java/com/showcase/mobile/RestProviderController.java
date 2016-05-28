package com.showcase.mobile;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.showcase.jpa.domain.CustomerList;
import com.showcase.mongo.domain.Movie;
import com.showcase.mongo.domain.MovieList;
import com.showcase.service.movies.MovieService;

@Controller
public class RestProviderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestProviderController.class);

	@Autowired
	private MovieService movieService;
	
	/*@Autowired
	private CustomerService custService;*/
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody CustomerList getAllCustomers() {
		LOGGER.debug("Provider has received request to getAllCustomers");

		// Call service here
		CustomerList result = new CustomerList();
		//result.setData(custService.findAllCustomers());

		LOGGER.debug("return the results");
		return result;
	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody MovieList getMovies() {
		LOGGER.debug("Provider has received request to get all movies");

		// Call service here
		MovieList result = new MovieList();
		result.setData(movieService.findAllMovies());
		
		/*custService.saveCustomer(new Customer("Gopinathan", "Mani"));
		custService.saveCustomer(new Customer("Praveen", "Karupaiya"));
		custService.saveCustomer(new Customer("Manikandan", "Syam"));
		custService.saveCustomer(new Customer("Selvan", "Kiran"));*/

		LOGGER.debug("return the results");
		return result;
	}
	
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody Movie getMovieById(@PathVariable("id") BigInteger id) {
		LOGGER.debug("Provider has received request to get movies with id: " + id);
		
		// Call service here
		return movieService.getMovieById(id);
	}
    
    @RequestMapping(value = "/movies/{searchBy}/{value}", method = RequestMethod.GET, headers="Accept=application/xml, application/json")
	public @ResponseBody MovieList findByAttrbutes(@PathVariable("searchBy") String searchBy, @PathVariable("value") String value) {
		LOGGER.debug("Provider has received request to get movies with searchBy :" + searchBy + " and value: " + value);
		
		// Call service here
		MovieList result = new MovieList();
		
		if (searchBy != null && searchBy.equalsIgnoreCase("music")) {
			result.setData(movieService.findByMusicDirector(value));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("director")) {
			result.setData(movieService.findByFlimDirector(value));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("title")) {
			result.setData(movieService.findByTitleLike(value));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("actor")) {
			result.setData(movieService.findByActorName(value));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("actress")) {
			result.setData(movieService.findByActressName(value));
		} else if (searchBy != null && searchBy.equalsIgnoreCase("year")) {
			int year = Integer.parseInt(value);
			result.setData(movieService.findByReleaseYear(year));
		} else {
			result.setData(movieService.findAllMovies());
		}
		
		LOGGER.debug("return the results");
		return result;
	}
    
    @RequestMapping(value = "/movies/save", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
    	LOGGER.debug("Provider has received request to updateMovie");
		
    	LOGGER.debug("Request : " + movie);
    	
    	List<Movie> movies = movieService.findByTitleLike(movie.getTitle());
    	
    	if (movies.isEmpty()) {
    		movieService.addMovie(movie);
    	}
		
		LOGGER.debug("return the results");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
