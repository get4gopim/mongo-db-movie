package com.showcase.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showcase.jpa.domain.Customer;
import com.showcase.jpa.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerDao;
	
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}
	
	public List<Customer> findAllCustomers() {
		/*Iterable<Customer> itr = customerDao.findAll();
		List<Customer> list = new ArrayList<Customer>();
		for (Customer cust : itr) {
			list.add(cust);
		}
		return list;*/
		return (List<Customer>) customerDao.findAll();
	}
}
