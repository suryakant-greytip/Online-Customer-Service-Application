package com.supportcenter.service;

import com.supportcenter.exception.CallException;
import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.exception.LogInException;

import java.util.List;

public interface OperatorService {

    public Issue addCustomerIssue(Issue issue) throws CustomerException, CallException;

    public String sendIntimationEmailToCustomer(Integer customerId) throws CustomerException;

    public Issue modifyCustomerIssue(Issue issue) throws IssueException;

    public String sendModificationEmailToCustomer(Integer customerId) throws CustomerException;

    public Issue closeCustomerIssue(Issue issue) throws IssueException;

    public Customer findCustomerById(Integer customerId) throws CustomerException;

    public List<Customer> findCustomerByName(String customerName) throws CustomerException;

    public Customer findCustomerByEmail(String email) throws CustomerException;

    public boolean lockCustomerWithOperator(Integer customerId, String opoeratorKey) throws CustomerException;

}
