package com.supportcenter.service;


import java.util.List;

import javax.security.auth.login.LoginException;

import com.supportcenter.DTO.OperatorDTO;
import com.supportcenter.exception.DepartmentException;
import com.supportcenter.exception.OperatorException;
import com.supportcenter.model.Department;
import com.supportcenter.model.Operator;

public interface AdminService {
	public Department addDepartment(Department d,String key) throws LoginException;
	public Department modifyDepartment(Department d,String key) throws DepartmentException,LoginException;
	public Department removeDepartment(Integer id,String key) throws DepartmentException,LoginException;
	public Department getDepartmentById(Integer id,String key) throws DepartmentException,LoginException;
	public Operator addOperator(Operator o,String key)throws LoginException;
	public OperatorDTO assignDeptToOperator(Integer oid,Integer did,String key) throws DepartmentException, OperatorException,LoginException;
	public Operator modifyOperator(Operator o,String key) throws OperatorException,LoginException;
	public Operator deleteOperator(Integer id,String key)throws OperatorException,LoginException;
	public List<Operator> getAllOperators(String key)throws LoginException;
	public Operator getOperatorById(Integer id,String key) throws OperatorException,LoginException;
	public List<Operator> getAllOperatorWithDeptId(Integer id,String key) throws DepartmentException,LoginException;

}
