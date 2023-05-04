package com.supportcenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("supportcenteroperator")
public class OperatorController {
	
	
	// for login 
	
	public String loginCustomer(@PathVariable(value = "username", required = true) String username,
								@PathVariable(value = "password", required = true) String password ) {
		
	}
	
	// add customer Issue
	
	public Issue addCustomerIssue(@PathVariable(value = "username", required = true) Integer customerId,
								  @ResponseBody Issue issue) {
		
	}
	
	// send intimation email to the customer
	
	
	// modify cusotmer issue
	
	public Isuse modifyCustomerIsssue(@PathVariable(value = "username", required = true) Integer customerId) {
		
	}
	
	
	// send modification email to the customer
	
	
	// close customer issue
	public Issue closeCustomerIssue(@PathVariable(value = "username", required = true) Integer customerId) {
		
	}
	
	
	// find customer by id
	
	@GetMapping("operator/{customerId}")
	public Customer findCustomerById(@PathVariable Integer customerId) {
		
	}
	
	// find customer by name
	
	@GetMapping("operator/{customerName}")
	public Customer findCustomerByName(@PathVariable String customerName) {
		
	}
	
	
	// find customer by email
	
	@GetMapping("operator/{customerEmail}")
	public Customer findCustomerByEmail(@PathVariable Email customerEmail) {
		
	}
	
	
	// lock customer
	
	
}
























