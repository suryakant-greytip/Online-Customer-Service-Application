package com.supportcenter.service;


import java.util.List;

import javax.security.auth.login.LoginException;

import com.supportcenter.DTO.OperatorDTO;
import com.supportcenter.exception.DepartmentException;
import com.supportcenter.exception.OperatorException;
import com.supportcenter.model.Department;
import com.supportcenter.model.Operator;

public interface AdminService {
	public Department addDepartment(Department d) throws LoginException;
	public Department modifyDepartment(Department d,Integer deptId) throws DepartmentException,LoginException;
	public Department removeDepartment(Integer id) throws DepartmentException,LoginException;
	public Department getDepartmentById(Integer id) throws DepartmentException,LoginException;
	public Operator addOperator(Operator o)throws LoginException;
	public OperatorDTO assignDeptToOperator(Integer oid,Integer did) throws DepartmentException, OperatorException,LoginException;
	public Operator modifyOperator(Operator o,Integer operatorId) throws OperatorException,LoginException;
	public Operator deleteOperator(Integer id)throws OperatorException,LoginException;
	public List<Operator> getAllOperators()throws LoginException;
	public Operator getOperatorById(Integer id) throws OperatorException,LoginException;
	public List<Operator> getAllOperatorWithDeptId(Integer id) throws DepartmentException,LoginException;

}
