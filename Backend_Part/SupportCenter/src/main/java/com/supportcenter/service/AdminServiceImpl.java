package com.supportcenter.service;

import com.supportcenter.exception.DepartmentException;
import com.supportcenter.exception.OperatorException;
import com.supportcenter.repository.DepartmentRepository;
import com.supportcenter.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    OperatorRepository operatorRepository;

    @Override
    public boolean addDepartment(Department department) throws DepartmentException {
        departmentRepository.save(department);
        return true;
    }

    @Override
    public boolean removeDepartment(Integer departmentId) throws DepartmentException {
        departmentRepository.deleteById(departmentId);
        return true;
    }

    @Override
    public Department modifyDepartment(Department department) throws DepartmentException {
        Department department1 = departmentRepository.findById(department.getDepartmentId()).get();
        department1.setDepartmentName(department1.getDepartmentName());

        departmentRepository.save(department1);
        return department1;
    }

    @Override
    public Department findDepartmentById(int id) throws DepartmentException {
        return departmentRepository.findById(id).get();
    }

    @Override
    public boolean addOperator(Integer departmentID, Operator operator) throws OperatorException {
        return operatorRepository.save(operator);
    }

    @Override
    public boolean removeOperator(Integer operatorId) throws OperatorException {
        operatorRepository.deleteById(operatorId);
        return true;
    }

    @Override
    public Operator modifyOperator(Operator operator) throws OperatorException {

        Operator operator1 = operatorRepository.findById(operator.getOperatorId()).get();
        operator1.setFirstName(operator.getFirstName());
        operator1.setLastName(operator.getLastName());
        operator1.setMobile(operator.getMobile());
        operator1.setEmail(operator.getEmail());
        operator1.setCity(operator.getCity());
        operatorRepository.save(operator1);
        return operator1;
    }

    @Override
    public Operator findOperatorbyId(Integer operatorId) throws OperatorException {
        return operatorRepository.findById(operatorId)
                .orElseThrow(() -> new OperatorException("Operator not found"));
    }

    @Override
    public List<Operator> findAllOperator() throws OperatorException {
        List<Operator> operators = operatorRepository.findAll();
        return operators;
    }
}
