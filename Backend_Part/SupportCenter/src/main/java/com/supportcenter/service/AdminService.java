package com.supportcenter.service;


import com.supportcenter.exception.DepartmentException;
import com.supportcenter.exception.OperatorException;
import com.supportcenter.model.Department;
import com.supportcenter.model.Operator;

import java.util.List;

public interface AdminService {
    public Department addDepartment(Department department)throws DepartmentException;

    public boolean removeDepartment(Integer departmentId)throws DepartmentException;

    public Department modifyDepartment(Department department)throws DepartmentException;

    public Department findDepartmentById(int id)throws DepartmentException;


    public Operator addOperator(Integer departmentID, Operator operator)throws OperatorException;

    public String removeOperator(Integer operatorId) throws OperatorException;

    public Operator modifyOperator(Operator operator)throws OperatorException;

    public Operator findOperatorbyId(Integer operatorId)throws OperatorException;

    public List<Operator> findAllOperator() throws OperatorException;

}
