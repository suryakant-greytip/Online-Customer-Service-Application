package com.supportcenter.service;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.model.Login;

import java.util.List;

public interface CustomerService {
    public String registerCustomer(Customer customer) throws CustomerException;
    public Issue viewIssueById(Integer issueId, Integer customerId) throws IssueException;
    public Issue reopenIssue(Integer issueId) throws IssueException;
    public List<Issue> viewAllIssueId(Integer customerId) throws CustomerException;
    public String changePassword(Integer customerId , Login credentials) throws CustomerException;
    public String forgotPassword(Integer customerId) throws CustomerException;
    public Customer emailPassword(Integer customerId) throws CustomerException;
}
