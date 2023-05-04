package com.supportcenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer>
{

	public String registerCustomer(Customer customer);

	// Customer will register himself by passing customer details.	
	
	
	public Issue viewIssueById(Integer issueId,  Integer customerId);
	
//	Customer will validate himself using customerId and with the help of issueId he can view his issue
	
	public Issue reopenIssue(Integer issueId);
//	for the issue closed if the 
	
	
	public List<Issue> viewAllIssue(Integer customerId);
	
	
	public String changePassword(Integer customerId , Login credentials);
	
	
	public String forgotPassword(Integer customerId);
	
	
	public Customer emailPassword(Integer customerId);
	
	public Customer findByEmail(String email);
	
	public List<Customer> findByFirstName(String firstName);
}
