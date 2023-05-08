package com.supportcenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer findByEmail(String email);
	  
	public List<Customer> findCustomerByFirstName(String name);
	
	public Customer findCustomerByMobile(String mobileNo);
}
