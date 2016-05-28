package com.showcase.mongo.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MovieList")
public class MovieList {

	@XmlElement(name="Movie")
	private List<Movie> data;

	public List<Movie> getMovieList() {
		return this.data;
	}

	public void setData(List<Movie> data) {
		this.data = data;
	}

}
