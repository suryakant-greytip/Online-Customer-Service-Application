package com.supportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.model.Status;
import com.supportcenter.service.OperatorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/operators")
public class OperatorController {
	
	@Autowired
	private OperatorService oS;
	
	@PostMapping("/addIssue")
	public ResponseEntity<String> addCustomerIssueHandler(@RequestBody @Valid Issue issue) throws IssueException {
		
		String s = oS.AddCustomerIssue(issue);
		
		return ResponseEntity.ok(s);
	}
	
	@PostMapping("/updateIssue")
	public ResponseEntity<String> modifyIssueHandler(@RequestBody @Valid Issue issue) throws IssueException {
		String s = oS.modifyIssue(issue);
		return ResponseEntity.ok(s);
	}
	
	@PostMapping("/closeIssue/{issueid}")
	public ResponseEntity<String> closeIssueHandler(@PathVariable @Valid Integer issueid) throws IssueException {
		String s = oS.closeCustomerIssue(issueid, Status.CLOSED);
		return ResponseEntity.ok(s);
	}
	
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getCustomersHandler() throws CustomerException {
		List<Customer> list = oS.findAllCustomer();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/customersid/{customerId}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable @Valid Integer customerId) throws CustomerException {
		Customer c = oS.findByCustomerId(customerId);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/customersname/{firstName}")
	public ResponseEntity<List<Customer>> getByFirstNameHandler(@PathVariable @Valid String firstName) throws CustomerException {
		List<Customer> c = oS.findCustomerByFirstName(firstName);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/customersemail/{email}")
	public ResponseEntity<Customer> getByEmailHandler(@PathVariable @Valid String email) throws CustomerException {
		Customer c = oS.findCustomerByEmail(email);
		return ResponseEntity.ok(c);
	}
	
//	@GetMapping("/customer/{mobNo}")
//	public ResponseEntity<Customer> getByMobileHandler (@PathVariable @Valid String mobNo) {
//		Customer c = oS.findCustomerByMobile(mobNo);
//		return ResponseEntity.ok(c);
//	}
	
	
}
























