package com.showcase.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 
 */
@XmlRootElement(name="Customer")
@Entity(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	@XmlAttribute
	private Long id;

	@Column(name="first_name")
	@XmlAttribute
	private String firstname;
	
	@Column(name="last_name")
	@XmlAttribute
	private String lastname;
	
	public Customer() {}
	
	public Customer(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
	
	
	
	
	
}