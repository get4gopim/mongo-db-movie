package com.showcase.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.showcase.jpa.domain.Customer;

/**
 * Repository to manage {@link Customer} instances.
 * 
 * @author 
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

	/**
	 * Returns a page of {@link Customer}s with the given lastname.
	 * 
	 * @param lastname
	 * @param pageable
	 * @return
	 */
	Page<Customer> findByLastname(String lastname, Pageable pageable);
}
