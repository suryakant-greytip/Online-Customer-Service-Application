package com.supportcenter.service;

import java.util.List;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;

import ch.qos.logback.core.status.Status;

public interface OperatorService {

public String AddCustomerIssue(Issue issue) throws IssueException;
	
	public String modifyIssue(Issue issue) throws IssueException;
	
	public String closeCustomerIssue(Integer IssueId, Status status) throws IssueException;
	
	public List<Customer> findAllCustomer() throws CustomerException;
	
	public Customer findByCustomerId(Integer cusId) throws CustomerException;
	
	public List<Customer> findCustomerByFirstName(String name) throws CustomerException;
	
	public Customer findCustomerByEmail(String email) throws CustomerException;
	
//	public Customer findCustomerByMobile(String mobile) throws CustomerException;


}
