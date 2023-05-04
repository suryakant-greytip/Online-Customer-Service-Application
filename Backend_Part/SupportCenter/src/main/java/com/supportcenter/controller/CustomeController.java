package com.supportcenter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("supportcentercustomer")
public class CustomeController {
	
	// for login 
	
	public String loginCustomer(@PathVariable(value = "username", required = true) String username,
								@PathVariable(value = "password", required = true) String password ) {
		
	}
	
	// for adding new customer
	
	public Customer registerCustomer(@Valid @ResponseBody Customer customer) {
		
	}
	
	// view particular issue details
	
	@GetMapping("cusotmerissues/{issueId}")
	public Issue viewIssuueDetails(@PathVariable(value = "issueId", required = true) Integer issueId) {
		
	}
	
	//view all issues details
	
	@GetMapping("cusotmerissues/{all}")
	public List<Issue> viewAllIssues(@PathVariable String all){
		if(all=="allissues") {
			
		}
	}
	
	//change passworf with the help of email and old password
	
	@PatchMapping("customer/{email}/{oldpassword}")
	public String changePassword(@PathVariable(value = "email", required = true) String email,
								@PathVariable(value = "oldpassword", required = true) String oldpassword) {
		
	}
	
	// set new password with email (forget password)
	
	@PatchMapping("customer/{email}")
	public String forgotPassword(@PathVariable(value = "email", required = true) String email){
		
	}
	
	
	
	// set email and password
}





































