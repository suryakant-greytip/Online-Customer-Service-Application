package com.supportcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.model.IssueStatus;
import com.supportcenter.repository.CustomerRepository;
import com.supportcenter.repository.IssueRepository;

@Service
public class OperatorServiceImpl implements OperatorService{

	@Override
	public Issue addCustomerIssue(Issue issue) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendIntimationEmailToCustomer(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue modifyCustomerIssue(Issue issue) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendModificationEmailToCustomer(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue closeCustomerIssue(Issue issue) throws IssueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerById(Integer customerId) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findCustomerByName(String customerName) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean lockCustomerWithOperator(Integer customerId, String operatorKey) throws CustomerException {
		// TODO Auto-generated method stub
		return false;
	}

    
}
