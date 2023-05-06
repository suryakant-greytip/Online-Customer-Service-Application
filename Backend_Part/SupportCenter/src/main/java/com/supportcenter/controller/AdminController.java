package com.supportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportcenter.exception.DepartmentException;
import com.supportcenter.exception.OperatorException;
import com.supportcenter.model.Department;
import com.supportcenter.model.Operator;
import com.supportcenter.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("supportcenteradmin")
public class AdminController {
	
	@Autowired
	private AdminService adminDao;
	
	
	// adding new department
	
	@PostMapping("/admin")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) throws DepartmentException 
	{
	     	return new ResponseEntity<>(adminDao.addDepartment(department),HttpStatus.CREATED);
	}
	
	// remove department
	
	@DeleteMapping("admin/{departmentName}")
	public ResponseEntity<Department> removeDepartment(@PathVariable String departmentName) throws DepartmentException 
	{
		return new ResponseEntity<>(adminDao.removeDepartment(null),HttpStatus.OK);
		
	}
	
	// modify department 
	
	@PutMapping("/admin/department")
	public ResponseEntity<Department> modifyDepartment(@Valid @RequestBody Department department) throws DepartmentException {
		return new ResponseEntity<>(adminDao.modifyDepartment(department),HttpStatus.OK);
		
	}
	
	// find department by id
	
	@GetMapping("admin/{departmentId}")
	public ResponseEntity<Department> findDepartmentById(@PathVariable Integer departmentId) throws DepartmentException {
		return new ResponseEntity<>(adminDao.findDepartmentById(departmentId),HttpStatus.OK);
		
	}
	
	// add operator 
	
	@PostMapping("/admin/{departmentId}/operator")
	public ResponseEntity<Operator> addOperator( @PathVariable Integer departmentId ,@Valid  @RequestBody Operator operator) throws OperatorException {
		return new ResponseEntity<>(adminDao.addOperator(departmentId, operator),HttpStatus.CREATED);
		
		
	}
	
	// remove operator
	
	@DeleteMapping("adminoperator/{operatorId}")
	public ResponseEntity<Operator> removeOperator(@PathVariable Integer operatorId) throws OperatorException 
	{
		return new ResponseEntity<>(adminDao.removeOperator(operatorId), HttpStatus.OK);
		
	}
	
	// modify operator
	
	@PutMapping("adminoperator/operator")
	public ResponseEntity<Operator>  modifyOperator(@Valid @RequestBody Operator operator) throws OperatorException 
	{
		return new ResponseEntity<>(adminDao.modifyOperator(operator),HttpStatus.OK);
		
	}
	
	// find operator by id
	
	@GetMapping("/adminoperator/{operatorId}")
	public ResponseEntity<Operator> findOperatorById(@PathVariable Integer operatorId) throws OperatorException {
		return new ResponseEntity<>(adminDao.findOperatorbyId(operatorId),HttpStatus.OK);
		
	}
	
	// find all operators
	
	@GetMapping("/adminoperator/all")
	public ResponseEntity<List<Operator>> getAllOperator() throws OperatorException{
		
		return new ResponseEntity<>(adminDao.findAllOperator(),HttpStatus.OK);
	}
	
	
	
}
