package com.supportcenter.service;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;

import java.util.List;

public interface CustomerService {
    public String registerCustomer(Customer customer) throws CustomerException;
    public Issue viewIssueById(Integer issueId,  Integer customerId);
    public Issue reopenIssue(Integer issueId) throws IssueException;
    public List<Issue> viewAllIssueId(Integer customerId);
    public String changePassword(Integer customerId , Login credentials) throws CustomerException;
    public String forgotPassword(Integer customerId);
    public Customer emailPassword(Integer customerId) throws CustomerException;
}
