package com.supportcenter.repository;

import java.util.List;

import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer>{

	public Issue addCustomerIssue(Issue issue);

    public String sendIntimationEmailToCustomer(Integer customerId);

    public Issue modifyCustomerIssue(Issue issue);

    public String sendModificationEmailToCustomer(Integer customerId);

    public Issue closeCustomerIssue(Issue issue);

    public Customer findCustomerById(Integer customerId);

    public List<Customer> findCustomerByName(String customerName);

    public Customer findCustomerByEmail(String email);

    @Query("Select customer.customerId from Customer customer where isActive = true and operatorId= ?1")
    public boolean lockCustomerWithOperator(Integer customerId, Integer operatorId);

	
	
	
}
