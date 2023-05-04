package com.supportcenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer>{

	public String registerCustomer(Customer customer);

	// Customer will register himself by passing customer details.	
	
	
	
	
	public Issue viewIssueById(Integer issueId,  Integer customerId);
	
//	Customer will validae himself using customerId and with the help of issueId he can view his issue
	
	public Issue reopenIssue(Integer issueId);
	public List<Issue> viewAllIssueId(Integer customerId);
	public String changePassword(Integer customerId , Login credentials);
	public String forgotPassword(Integer customerId);
	public Customer emailPassword(Integer customerId);
}
