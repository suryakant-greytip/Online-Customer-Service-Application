package com.supportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.model.Login;
import com.supportcenter.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("supportcentercustomer")
public class CustomeController {
	
	@Autowired
	public CustomerService dao;
	
	// for login 
	
//	public String loginCustomer(@PathVariable(value = "username", required = true) String username,
//								@PathVariable(value = "password", required = true) String password ) {
//		
//	}
	
	// for adding new customer
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
		Customer cus = dao.registerCustomer(customer);
		return new ResponseEntity<>(cus, HttpStatus.ACCEPTED) ;
	}
	
	// view particular issue details
	
	@GetMapping("viewissues/{customerId}/{issueId}")
	public ResponseEntity<Issue> viewIssuueDetailsById(@PathVariable(value = "issueId", required = true) Integer issueId
									,@PathVariable(value = "customerId", required = true) Integer customerId ) throws IssueException {
		Issue is = dao.viewIssueById(issueId, customerId);
		return new ResponseEntity<>(is,HttpStatus.OK);
	}
	
	//view all issues details
	
	@GetMapping("cusotmerissues/{customerId}")
	public ResponseEntity<List<Issue>> viewAllIssues(@PathVariable(value = "customerId", required = true) Integer customerId ) throws CustomerException{
		List<Issue> list = dao.viewAllIssueId(customerId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	//change password with the help of email and old password
	
	@PatchMapping("customer/{customerId}")
	public ResponseEntity<Customer> changePassword(@PathVariable(value = "email", required = true) Integer customerId,
								@RequestBody Login credential) throws CustomerException {
		Customer cus = dao.changePassword(customerId, credential);
		return new ResponseEntity<>(cus ,HttpStatus.OK);
	}
	
	// set new password with email (forget password)
	
	@PatchMapping("customer/{customerId}")
	public ResponseEntity<String> forgotPassword(@PathVariable(value = "customerId", required = true) Integer customerId) throws CustomerException{
		
		return new ResponseEntity<>(dao.forgotPassword(customerId), HttpStatus.OK);
	}
	
	
	
	// set email and password
	@PatchMapping("customer/{customerId}")
	public ResponseEntity<Customer> emailPassword(@PathVariable(value = "customerId", required = true) Integer customerId) throws CustomerException{
		Customer cus = dao.emailPassword(customerId);
		return new ResponseEntity<>(cus, HttpStatus.OK);
	}
}





































