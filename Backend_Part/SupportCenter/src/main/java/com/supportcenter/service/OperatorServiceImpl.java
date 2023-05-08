package com.supportcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.supportcenter.exception.CustomerException;
import com.supportcenter.exception.IssueException;
import com.supportcenter.model.Customer;
import com.supportcenter.model.Issue;
import com.supportcenter.model.IssueStatus;
import com.supportcenter.repository.CustomerRepository;
import com.supportcenter.repository.IssueRepository;

@Service
public class OperatorServiceImpl implements OperatorService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public Issue addCustomerIssue(Issue issue) throws IssueException {
        Issue issue1 = issueRepository.save(issue);

        if(issue1.getIssueId() != null){
            return issue1;
        }
        else {
            throw new IssueException("Issue could not be saved");
        }
    }

    @Override
    public String sendIntimationEmailToCustomer(Integer customerId) throws CustomerException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerException("No customer with this Id found"));

        String email = customer.getEmail();

        return "To "+email+"\nThis is an Intimation Email to customer = "+customer.getFirstName()+" "+customer.getLastName()+"\n Regards Customer Service";
    }


    @Override
    public Issue modifyCustomerIssue(Issue issue) throws IssueException {
        issueRepository.findById(issue.getIssueId()).orElseThrow(() -> new IssueException("No Issue found."));

        return issueRepository.save(issue);
    }

    @Override
    public String sendModificationEmailToCustomer(Integer customerId) throws CustomerException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerException("No such customer with id="+customerId+" exist"));

        return "Dear " + customer.getFirstName() + ",\n\n" +
                "We would like to inform you that your issue with ID " +
                customer.getIssues().get(0).getIssueId() + " has been modified.\n\n" +
                "Thank you for using our service.\n\n" +
                "Best regards,\n" +
                "The Support Team";
    }

    @Override
    public Issue closeCustomerIssue(Issue issue) throws IssueException {

        Issue notResolvedIssue = issueRepository.findById(issue.getIssueId()).orElseThrow(() -> new IssueException("No such issue found"));

        issue.setStatus(IssueStatus.valueOf("RESOLVED"));

        return issueRepository.save(issue);
    }

    @Override
    public Customer findCustomerById(Integer customerId) throws CustomerException {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerException("No such customer found with id="+customerId));
    }

    @Override
    public List<Customer> findCustomerByName(String customerName) throws CustomerException {
        List<Customer> customers = customerRepository.findByFirstName(customerName);

        if(customers.isEmpty()) throw new CustomerException("No customer found with Fist Name = "+customerName);

        return customers;
    }

    @Override
    public Customer findCustomerByEmail(String email) throws CustomerException {
        Customer customer = customerRepository.findByEmail(email);

        if(customer==null) throw new CustomerException("No customer found with email="+email);

        return customer;
    }

    
	@Override
	public boolean lockCustomerWithOperator(Integer customerId, String operatorKey) throws CustomerException {
		// TODO Auto-generated method stub
		return false;
	}
}
