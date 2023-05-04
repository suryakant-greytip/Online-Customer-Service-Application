package com.supportcenter.controller;

import java.util.List;

import org.springframework.expression.spel.ast.Operator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("supportcenteradmin")
public class AdminController {
	
	// adding new department
	
	@PostMapping("admin")
	public Department addDepartment(@Valid @ResponseBody Department department) {
		
	}
	
	// remove department
	
	@DeleteMapping("admin/{departmentName}")
	public Department removeDepartment(@PathVariable String departmentName) {
		
	}
	
	// modify department 
	
	public Department modifyDepartment() {
		
	}
	
	// find department by id
	
	@GetMapping("admin/{departmentId}")
	public Department findDepartmentById(@PathVariable Integer departmentId) {
		
	}
	
	// add operator 
	
	@PostMapping("adminoperator")
	public Operator addOperator(@Valid @ResponseBody Operator operator) {
		
	}
	
	// remove operator
	
	@DeleteMapping("adminoperator/{operatorName}")
	public Operator removeOperator(@PathVariable String operatorName) {
		
	}
	
	// modify operator
	
	public Operator modifyOperator() {
		
	}
	
	// find operator by id
	
	@GetMapping("adminoperator/{operatorId}")
	public Operator findOperatorById(@PathVariable Integer operatorId) {
		
	}
	
	// find all operators
	
	@GetMapping("adminoperator/all")
	public List<Operator> getAllOperator(@PathVariable String all){
		if(all=="allissues") {
			
		}
	}
	
	
	
}
