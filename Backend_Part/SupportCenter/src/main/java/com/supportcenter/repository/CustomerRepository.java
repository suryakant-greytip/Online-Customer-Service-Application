package com.supportcenter.repository;

import java.util.List;

import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    public Issue addCustomerIssue(Issue issue);
	
	public String sendIntimationEmailToCustomer(Integer customerId , Integer issueId);
	
	public Issue modifyCustomerIssue(Issue issue);
	
	public String sentModificationEmailToCustomer(Integer customerId , Integer issueId);
	
	public String closeCustomerIssue(Integer issueId, Integer customerId);
	
	public Customer findCustomerById(Integer customerId);
	
	public List<Customer> findCustomerByName(String name);
	
	public Customer findCustomerByEmail(String email);
	
	public String lockCustomer(Integer customerId);
	
	
	public List<Customer> findByFirstName(String firstName);
	
	public Customer findByEmail(String email);
}
