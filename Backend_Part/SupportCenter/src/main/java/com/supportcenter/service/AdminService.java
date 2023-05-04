package com.supportcenter.service;

import com.supportcenter.exception.DepartmentException;
import com.supportcenter.exception.OperatorException;
import org.springframework.expression.spel.ast.Operator;

public interface AdminService {
    public boolean addDepartment(Department department)throws DepartmentException;

    public boolean removeDepartment(Integer departmentId)throws DepartmentException;

    public Department modifyDepartment(Department department)throws DepartmentException;

    public Department findDepartmentById(int id)throws DepartmentException;


    public boolean addOperator(Integer departmentID,Operator operator)throws OperatorException;

    public boolean removeOperator(Integer operatorId) throws OperatorException;

    public Operator modifyOperator(Operator operator)throws OperatorException;

    public Operator findOperatorbyId(Integer operatorId)throws OperatorException;

    public List<Operator> findAllOperator() throws OperatorException;

}
