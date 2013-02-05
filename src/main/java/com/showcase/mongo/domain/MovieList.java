package com.showcase.mongo.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Movies")
public class MovieList {

	private List<Movie> data;

	public List<Movie> getData() {
		return data;
	}

	public void setData(List<Movie> data) {
		this.data = data;
	}

}
