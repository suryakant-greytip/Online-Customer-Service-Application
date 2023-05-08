package com.supportcenter.service;

import java.util.List;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.model.Login;

public interface CustomerService {
public Customer registerCustomer(Customer customer);
	
	public String changePassword(Login login) throws CustomerException;
	public String forgetPassword(Integer id) throws CustomerException;
	public Customer emailPassword(Integer id) throws CustomerException;
	public Issue viewissue(Integer id, String key) throws CustomerException;
	public List<Issue> getAllIssue(String key) throws CustomerException;
	public String reopenIssue(Integer id, String key) throws CustomerException;
}
