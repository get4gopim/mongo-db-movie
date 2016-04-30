package com.showcase.service.customer;

import java.util.List;

import com.showcase.jpa.domain.Customer;

public interface CustomerService {
	
	public void saveCustomer(Customer customer);
	
	public List<Customer> findAllCustomers();

}
