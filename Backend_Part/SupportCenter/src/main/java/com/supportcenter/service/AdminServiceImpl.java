package com.supportcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportcenter.exception.DepartmentException;
import com.supportcenter.exception.OperatorException;
import com.supportcenter.model.Department;
import com.supportcenter.model.Operator;
import com.supportcenter.repository.DepartmentRepository;
import com.supportcenter.repository.OperatorRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public Department addDepartment(Department department) throws DepartmentException {
        return departmentRepository.save(department);
    }

    @Override
    public boolean removeDepartment(Integer departmentId) throws DepartmentException {
        if (departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
            return true;
        } else {
            throw new DepartmentException("Department not found");
        }
    }

    @Override
    public Department modifyDepartment(Department department) throws DepartmentException {
        Department existingDepartment = departmentRepository.findById(department.getDepartmentId())
                .orElseThrow(() -> new DepartmentException("Department not found"));
        existingDepartment.setDepartmentId(department.getDepartmentId());
        existingDepartment.setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(existingDepartment);
    }

    @Override
    public Department findDepartmentById(int id) throws DepartmentException {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentException("Department not found"));
    }

    @Override
    public Operator addOperator(Integer departmentID, Operator operator) throws OperatorException {
        Department department = departmentRepository.findById(departmentID)
                .orElseThrow(() -> new OperatorException("Department not found"));
        operator.setDepartment(department);
        return operatorRepository.save(operator);
    }

    @Override
    public String removeOperator(Integer operatorId) throws OperatorException {
        if (operatorRepository.existsById(operatorId)) {
            operatorRepository.deleteById(operatorId);
            return "Operator Removed";
        } else {
            throw new OperatorException("Operator not found");
        }
    }

    @Override
    public Operator modifyOperator(Operator operator) throws OperatorException {
        Operator existingOperator = operatorRepository.findById(operator.getOperatorId())
                .orElseThrow(() -> new OperatorException("Operator not found"));
        existingOperator.setFirstName(operator.getFirstName());
        existingOperator.setLastName(operator.getLastName());
        existingOperator.setMobile(operator.getMobile());
        existingOperator.setEmail(operator.getEmail());
        existingOperator.setCity(operator.getCity());
        return operatorRepository.save(existingOperator);
    }

    @Override
    public Operator findOperatorbyId(Integer operatorId) throws OperatorException {
        return operatorRepository.findById(operatorId)
                .orElseThrow(() -> new OperatorException("Operator not found"));
    }

    @Override
    public List<Operator> findAllOperator() throws OperatorException {
        List<Operator> operatorList = operatorRepository.findAll();
    }
}
