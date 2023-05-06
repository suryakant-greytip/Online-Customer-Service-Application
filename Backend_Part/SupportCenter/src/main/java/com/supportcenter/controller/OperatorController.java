package com.supportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.service.OperatorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("supportcenteroperator")
public class OperatorController {
	
	@Autowired
	public OperatorService dao;
	
	// for login 
	
//	public String loginCustomer(@PathVariable(value = "username", required = true) String username,
//								@PathVariable(value = "password", required = true) String password ) {
//		
//	}
	
	// add customer Issue
	@PostMapping("/customerIssue")
	public ResponseEntity<Issue> addCustomerIssue(@Valid @RequestBody Issue issue) throws IssueException 
	{
		return new ResponseEntity<>(dao.addCustomerIssue(issue),HttpStatus.OK);
	   	
	}
	
	@PutMapping("/customerIssue")
	public ResponseEntity<Issue> modifyCustomerIssue(@Valid @RequestBody Issue issue) throws IssueException 
	{
		return new ResponseEntity<>(dao.modifyCustomerIssue(issue),HttpStatus.OK);
		
	}
	
	// send modification email to the customer
	
	
	// close customer issue
	public ResponseEntity<Issue> closeCustomerIssue(@Valid @RequestBody Issue issue) throws IssueException
    {
		return new ResponseEntity<>(dao.modifyCustomerIssue(issue),HttpStatus.OK);
	 }
	
	
	// find customer by id
	
	@GetMapping("operator/{customerId}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable Integer customerId) throws CustomerException 
	{
		return new ResponseEntity<>(dao.findCustomerById(customerId),HttpStatus.OK);
		
	}
	
	// find customer by name
	
	@GetMapping("operator/{customerName}")
	public  ResponseEntity<List<Customer>> findCustomerByName(@PathVariable String customerName) throws CustomerException {
		return new ResponseEntity<>(dao.findCustomerByName(customerName),HttpStatus.OK);
	}
	
	
	// find customer by email
	
	@GetMapping("operator/{customerEmail}")
	public ResponseEntity<Customer> findCustomerByEmail(@PathVariable String customerEmail) throws CustomerException {
		return new ResponseEntity<>(dao.findCustomerByEmail(customerEmail),HttpStatus.OK);
		
	}
	
	
	// lock customer
	
	
}
























