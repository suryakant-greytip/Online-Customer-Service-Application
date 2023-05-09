package com.supportcenter.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

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

import com.supportcenter.DTO.OperatorDTO;
import com.supportcenter.exception.DepartmentException;
import com.supportcenter.exception.OperatorException;
import com.supportcenter.model.Department;
import com.supportcenter.model.Operator;
import com.supportcenter.service.AdminService;
import com.supportcenter.service.OperatorService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private OperatorService optService;
	   
	
	@PostMapping("/depart/add")
	public ResponseEntity<Department>  addDepartment(@Valid @RequestBody Department deprt) throws LoginException{
		  System.out.println(deprt);
		  
		  
		return new ResponseEntity<>(adminService.addDepartment(deprt, "ADMIN"), HttpStatus.CREATED);
	}
	
	@PutMapping("depart/update/{key}")
	public ResponseEntity<Department>  modifyDepartment(@Valid @RequestBody Department deprt, @PathVariable String key) throws LoginException, DepartmentException{
		
		  return new ResponseEntity<>(adminService.modifyDepartment(deprt, key), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/depart/delete/{deptId}/{key}")
	private ResponseEntity<Department> deleteDepartment(@PathVariable Integer deptId, @PathVariable String key) throws LoginException, DepartmentException {
		 
		return new ResponseEntity<Department>(adminService.removeDepartment(deptId, key), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("depart/get/{deptId}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Integer deptId, @PathVariable String key) throws LoginException, DepartmentException{
		    
	   return new ResponseEntity<Department>(adminService.getDepartmentById(deptId, key), HttpStatus.ACCEPTED);
		
	}
	
	
	@PostMapping("operator/add/{key}")
	public ResponseEntity<Operator>  addOPerator(@Valid @RequestBody Operator opt, @PathVariable String key) throws LoginException{
		     
         return new ResponseEntity<Operator>(adminService.addOperator(opt, key), HttpStatus.ACCEPTED);
		 
	}
	
	@PutMapping("operator/update/{key}")
	public ResponseEntity<Operator>   modifyOperator(@Valid @RequestBody Operator opt, @PathVariable String key) throws LoginException, OperatorException{
		   
		return new ResponseEntity<Operator>(adminService.modifyOperator(opt, key), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("operator/delete/{key}")
	public ResponseEntity<Operator> deleteOperator(@RequestBody Integer optId, @PathVariable String key) throws LoginException, OperatorException{
		   return new ResponseEntity<Operator>(adminService.deleteOperator(optId, key), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("operator/all/{key}")
	public ResponseEntity<List<Operator>> getAllOperator(@PathVariable String key) throws LoginException{
		    return new ResponseEntity<List<Operator>>(adminService.getAllOperators(key), HttpStatus.OK);
	}
	
	
	@GetMapping("operator/get/{id}/{key}")
	public ResponseEntity<Operator> getOperatorById(@PathVariable Integer id, @PathVariable String key) throws LoginException, OperatorException{
		   return new ResponseEntity<Operator>(adminService.getOperatorById(id, key), HttpStatus.OK);
	}
	
	@GetMapping("operator/getdept/{id}/{key}")
	public ResponseEntity<List<Operator>> getAllOperatorByDeptId(@PathVariable Integer id, @PathVariable String key) throws LoginException, DepartmentException{
		   return new ResponseEntity<List<Operator>>(adminService.getAllOperatorWithDeptId(id, key), HttpStatus.OK);
	}
	
	@PostMapping("operator/assign/{key}")
	private ResponseEntity<OperatorDTO> assignDepartmentToOperator(@Valid @RequestBody OperatorDTO optDto, @PathVariable String key) throws LoginException, DepartmentException, OperatorException{
		  return new ResponseEntity<OperatorDTO>(adminService.assignDeptToOperator(optDto.getId(),optDto.getDept_id(), key), HttpStatus.OK);
	}
	
	
	
}
