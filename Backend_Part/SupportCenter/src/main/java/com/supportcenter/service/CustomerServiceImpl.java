package com.supportcenter.service;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.model.IssueStatus;
import com.supportcenter.model.Login;
import com.supportcenter.repository.CustomerRepository;
import com.supportcenter.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public String registerCustomer(Customer customer) throws CustomerException {
        Customer existedCustomer = customerRepository.findByEmail(customer.getEmail());
        if(existedCustomer!=null) {
            throw new CustomerException("This customer already exist");
        }

        Customer registerCustomer = customerRepository.save(customer);

        return "Customer Register Successfully!";
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
    public List<Issue> viewAllIssueId(Integer customerId) {
        return null;
    }

    @Override
    public String changePassword(Integer customerId, Login credentials) throws CustomerException {
        Customer customer = customerRepository.findByEmail(credentials.getUsername());
        if(customer == null) {
            throw new CustomerException("Invalid Credentials");
        }

        customer.setPassword(credentials.getPassword());
        customerRepository.save(customer);
        return "Password changed successfully";
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
