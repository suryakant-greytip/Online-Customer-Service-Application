package com.supportcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supportcenter.model.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>{


}
