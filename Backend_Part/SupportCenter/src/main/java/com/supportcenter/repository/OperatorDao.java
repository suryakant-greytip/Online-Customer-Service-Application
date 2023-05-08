package com.supportcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supportcenter.model.Operator;

@Repository
public interface OperatorDao  extends JpaRepository<Operator, Integer>{

}
