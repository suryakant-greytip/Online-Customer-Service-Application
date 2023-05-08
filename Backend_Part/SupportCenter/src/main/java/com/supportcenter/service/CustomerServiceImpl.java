package com.supportcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.model.CurrentUserSession;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.model.LoginDTO;
import com.supportcenter.model.Status;
import com.supportcenter.repository.CurrentUserSessionRepository;
import com.supportcenter.repository.CustomerRepository;
import com.supportcenter.repository.IssueRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository cr;
	
	@Autowired
	private CurrentUserSessionRepository currentsession;
	
	@Autowired
	private IssueRepository issueRepo;

	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		
		
		Customer existingCustomer= cr.findCustomerByMobile(customer.getMobile());
		
		
		
		if(existingCustomer != null) 
			throw new CustomerException("Customer Already Registered with Mobile number");
			
		
		
		
			return cr.save(customer);
			
			
		}
	@Override
	public String changePassword(LoginDTO login) throws CustomerException {
		
		Customer c = cr.findByEmail(login.getMobileNo());
		
		if(c==null) {
			throw new CustomerException("Invalid Credentials");
		}
		
		c.setPassword(login.getPassword());
		cr.save(c);
		return "Password Changed";
	}

	@Override
	public String forgetPassword(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer c = cr.findById(id).get();
		
		if(c==null) {
			throw new CustomerException("Invalid Customer id");
		}
		String temp = RandomString.make(6);
		c.setPassword(temp);
		cr.save(c);
		return "Your Temporary Password is " + temp;
	}

	@Override
	public Customer emailPassword(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer c = cr.findById(id).get();
		
		if(c==null) {
			throw new CustomerException("Invalid Customer Id");
		}
		else {
			return c;
		}
	}

	@Override
	public Issue viewissue(Integer id, String key) throws CustomerException {
		// TODO Auto-generated method stub
		
		CurrentUserSession session = currentsession.findByUuid(key);
		
		if(session==null) {
			throw new CustomerException("Please Login to continue");
		}
		else {
			Issue i = issueRepo.findById(id).get();
			
			if(i==null) {
				throw new CustomerException("No Issue find with Id: "+id);
			}
			else {
				return i;
			}
		}
		
	}

	@Override
	public List<Issue> getAllIssue(String key) throws CustomerException {
		// TODO Auto-generated method stub
		
		CurrentUserSession session = currentsession.findByUuid(key);
		
		if(session==null) {
			throw new CustomerException("Please Login to continue");
		}
		else {
			List<Issue> i = cr.findById(session.getId()).get().getIssue();
			
			if(i==null) {
				throw new CustomerException("No Issue found");
			}
			else {
				return i;
			}
		}
		
	}

	@Override
	public String reopenIssue(Integer id,String key) throws CustomerException {
		// TODO Auto-generated method stub
		CurrentUserSession session = currentsession.findByUuid(key);
		if(session==null) {
			throw new CustomerException("Please Login to continue");
		}
		else {
			Customer c = cr.findById(session.getId()).get();
			
			List<Issue> listIssue = c.getIssue();
			
			Issue issue = null;
			
			for(Issue I: listIssue) {
				if(I.getIssueId()==id) {
					issue = I;
				}
			}
			
			if(issue==null) {
				throw new CustomerException("Invalid Issue Id");
			}
			else {
				issue.setStatus(Status.OPEN);
				cr.save(c);
				return "Issue Opened Succesfully";
			}
		}
	}
}
