package com.showcase.mongo.domain;

public class IMDBMovie {
	
	/*
	 * <movie>
		 * <imdbid>tt0120689</imdbid>
		 * <imdburl>http://www.imdb.com/title/tt0120689/</imdburl>
		 * <genres>Crime,Drama,Fantasy,Mystery</genres>
		 * <languages>English,French</languages>
		 * <country>USA</country>
		 * <votes>321607</votes>
		 * <stv>0</stv>
		 * <series>0</series>
		 * <rating>8.4</rating>
		 * <runtime>189min</runtime>
		 * <title>The Green Mile</title>
		 * <year>1999</year>
		 * <usascreens>2875</usascreens>
		 * <ukscreens>340</ukscreens>
		 * </movie>
	 */
	
	private String imdbid;
	private String imdburl;
	private String genres;
	private String languages;
	private String country;
	private String votes;
	private String stv;
	private String series;
	private String rating;
	private String runtime;
	private String title;
	private String year;
	private String usascreens;
	private String ukscreens;
	
	public String getImdbid() {
		return imdbid;
	}
	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}
	public String getImdburl() {
		return imdburl;
	}
	public void setImdburl(String imdburl) {
		this.imdburl = imdburl;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getVotes() {
		return votes;
	}
	public void setVotes(String votes) {
		this.votes = votes;
	}
	public String getStv() {
		return stv;
	}
	public void setStv(String stv) {
		this.stv = stv;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getUsascreens() {
		return usascreens;
	}
	public void setUsascreens(String usascreens) {
		this.usascreens = usascreens;
	}
	public String getUkscreens() {
		return ukscreens;
	}
	public void setUkscreens(String ukscreens) {
		this.ukscreens = ukscreens;
	}
	
	@Override
	public String toString() {
		return "IMDBMovie [imdbid=" + imdbid + ", imdburl=" + imdburl
				+ ", genres=" + genres + ", languages=" + languages
				+ ", country=" + country + ", votes=" + votes + ", stv=" + stv
				+ ", series=" + series + ", rating=" + rating + ", runtime="
				+ runtime + ", title=" + title + ", year=" + year
				+ ", usascreens=" + usascreens + "]";
	}
	
	

	

}
