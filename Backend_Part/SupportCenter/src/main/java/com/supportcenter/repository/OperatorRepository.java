package com.supportcenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Repository;

import com.supportcenter.exception.CallException;
import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.service.Customer;
import com.supportcenter.service.Issue;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer>{

	public Issue addCustomerIssue(Issue issue) throws CustomerException, CallException;

    public String sendIntimationEmailToCustomer(Integer customerId) throws CustomerException;

    public Issue modifyCustomerIssue(Issue issue) throws IssueException;

    public String sendModificationEmailToCustomer(Integer customerId) throws CustomerException;

    public Issue closeCustomerIssue(Issue issue) throws IssueException;

    public Customer findCustomerById(Integer customerId) throws CustomerException;

    public List<Customer> findCustomerByName(String customerName) throws CustomerException;

    public Customer findCustomerByEmail(String email) throws CustomerException;

    public boolean lockCustomerWithOperator(Integer customerId, String opoeratorKey) throws CustomerException;

	
	
	
}
