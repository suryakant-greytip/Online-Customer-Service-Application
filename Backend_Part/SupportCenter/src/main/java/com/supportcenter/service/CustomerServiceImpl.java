package com.supportcenter.service;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
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
    public Issue viewIssueById(Integer issueId, Integer customerId) {
        return issueRepository.findById(issueId)
                .orElseThrow(() -> new IssueException("Issue with id="+issueId+" does not exist"));
    }

    @Override
    public Issue reopenIssue(Integer issueId) throws IssueException {
        Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new IssueException("Issue with id="+issueId+" does not exsit"));

        if(issue.getIssueStatus().toString().equals("NOT_RESOLVED")) throw new IssueException("This issue is Open");
        issue.setIssueStatus(IssueStatus.valueOf("NOT_RESOLVED"));

        return issueRepository.save(issue);
    }

    @Override
    public List<Issue> viewAllIssueId(Integer customerId) {
        return null;
    }

    @Override
    public String changePassword(Integer customerId, Login credentials) throws CustomerException {
        Customer customer = customerRepository.findByEmail(credentials.getEmail());
        if(customer == null) {
            throw new CustomerException("Invalid Credentials");
        }

        customer.setPassword(credentials.getPassword());
        customerRepository.save(c);
        return "Password changed successfully";
    }

    @Override
    public String forgotPassword(Integer customerId) {
        return null;
    }

    @Override
    public Customer emailPassword(Integer customerId) throws CustomerException {
        Customer customer = customerRepository.findById(customerId).get();

        if(customer == null) {
            throw new CustomerException("Invalid Customer Id");
        }
        else {
            return customer;
        }
    }
}
