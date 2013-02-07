package com.showcase.jpa.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CustomerList")
public class CustomerList {
	
	@XmlElement(name="Customer")
	private List<Customer> data;

	/*public List<Customer> getData() {
		return data;
	}*/

	public void setData(List<Customer> data) {
		this.data = data;
	}

	

}
