package com.showcase.mongo.domain;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name="Movie")
@Document
public class Movie {

	@Id
	private BigInteger id;

	private String title;
	
	private String type;
	
	private boolean isAvailable;
	
	private String actorName;
	
	private String actressName;
	
	private String musicDirector;
	
	private String flimDirector;
	
	private String imageUrl;
	

	public Movie() {
		super();
	}

	public Movie(String title, String type, boolean isAvailable,
			String actorName, String actressName, String musicDirector,
			String flimDirector, String imageUrl) {
		super();
		this.title = title;
		this.type = type;
		this.isAvailable = isAvailable;
		this.actorName = actorName;
		this.actressName = actressName;
		this.musicDirector = musicDirector;
		this.flimDirector = flimDirector;
		this.imageUrl = imageUrl;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActressName() {
		return actressName;
	}

	public void setActressName(String actressName) {
		this.actressName = actressName;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	public String getFlimDirector() {
		return flimDirector;
	}

	public void setFlimDirector(String flimDirector) {
		this.flimDirector = flimDirector;
	}
	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", type=" + type
				+ ", isAvailable=" + isAvailable + ", actorName=" + actorName
				+ ", actressName=" + actressName + ", musicDirector="
				+ musicDirector + ", flimDirector=" + flimDirector
				+ ", imageUrl=" + imageUrl + "]";
	}

}
