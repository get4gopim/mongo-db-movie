package com.showcase.mongo.domain;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback {

	@Id
	private BigInteger id;

	private String username;
	
	private String email;
	
	private String comments;
	
	public Feedback(String username, String email,
			String comments) {
		super();
		this.username = username;
		this.email = email;
		this.comments = comments;
	}

	public Feedback() {
		super();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", username=" + username + ", email="
				+ email + ", comments=" + comments + "]";
	}

	
	
	
}
