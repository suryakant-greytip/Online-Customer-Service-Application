package com.supportcenter.service;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.model.*;
import com.supportcenter.repository.CustomerRepository;
import com.supportcenter.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public Customer registerCustomer(Customer customer) throws CustomerException {
        Customer existedCustomer = customerRepository.findByEmail(customer.getEmail());
        if(existedCustomer!=null) {
            throw new CustomerException("This customer already exist");
        }

        Customer registerCustomer = customerRepository.save(customer);

        return registerCustomer;
    }

    @Override
    public Issue viewIssueById(Integer issueId, Integer customerId) throws IssueException {
        return issueRepository.findById(issueId).orElseThrow(() -> new IssueException("Issue with id="+issueId+" does not exist"));
    }

    @Override
    public Issue reopenIssue(Integer issueId) throws IssueException {
        Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new IssueException("Issue with id="+issueId+" does not exsit"));

        if(issue.getStatus().toString().equals("CLOSED")) throw new IssueException("This issue is Open");
        issue.setStatus(IssueStatus.valueOf("CLOSED"));

        return issueRepository.save(issue);
    }

    @Override
    public List<Issue> viewAllIssueId(Integer customerId) throws CustomerException {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            List<Issue> issues = customer.getIssues();
            if (issues == null || issues.isEmpty()) {
                throw new CustomerException("No issues found for customer with id: " + customerId);
            } else {
                return issues;
            }
        } else {
            throw new CustomerException("Customer with id: " + customerId + " not found");
        }
    }

    @Override
    public Customer changePassword(Integer customerId, Login credentials) throws CustomerException {
        Customer customer = customerRepository.findByEmail(credentials.getUsername());
        if(customer == null) {
            throw new CustomerException("Invalid Credentials");
        }

        customer.setPassword(credentials.getPassword());
        
        return customerRepository.save(customer);
    }

    @Override
    public String forgotPassword(Integer customerId) {

        Customer customer = customerRepository.findById(customerId).get();

        customer.setPassword("12345");
        customerRepository.save(customer);
        return "Your Temporary Password is '12345'";
    }

    @Override
    public Customer emailPassword(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).get();

        return customer;
    }
}
