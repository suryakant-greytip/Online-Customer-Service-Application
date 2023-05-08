package com.supportcenter.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportcenter.model.CurrentUserSession;
import com.supportcenter.model.Customer;
import com.supportcenter.model.LoginDTO;
import com.supportcenter.repository.AdminRepository;
import com.supportcenter.repository.CurrentUserSessionRepository;
import com.supportcenter.repository.CustomerRepository;
import com.supportcenter.repository.OperatorRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomerRepository cDao;

	@Autowired
	OperatorRepository operatorDao;

	@Autowired
	CurrentUserSessionRepository sDao;

	@Autowired
	AdminRepository adminDao;
	
	
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException{
		
		
		Customer existingCustomer= cDao.findCustomerByMobile(dto.getMobileNo());
		
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid mobile number");
			
			 
		}

		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getCustomerId());

		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
	
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			sDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		
		
	}
	
	
	
	
	/*

	@Override
	public String loginUser(Login login) throws LoginException {

		CurrentUserSession currentUserSession;
		
		login.setUser_Type(login.getUser_Type());

		System.out.println(login.getUser_Type());
		
		// checking for customer
		if (login.getUser_Type().equalsIgnoreCase("CUSTOMER")) {

			
			Customer existCustomer = customerDao.findByEmail(login.getEmail());

			if (existCustomer == null)
				throw new LoginException("Please Enter a valid Email login");

			Optional<CurrentUserSession> validCustomerSession = sessionDao.findById(existCustomer.getCustomerId());

			if (validCustomerSession.isPresent()) {

				throw new LoginException("User already Logged ");

			}

			if (existCustomer.getPassword().equals(login.getPassword())) {

				String key = UUID.randomUUID().toString();

				currentUserSession = new CurrentUserSession(existCustomer.getCustomerId(), key, LocalDateTime.now(),
						login.getUser_Type());

				sessionDao.save(currentUserSession);

				return key;
			} else
				throw new LoginException("Passowrd incorrect");
		}

		/// checking for Admin
		if (login.getUser_Type().equals("ADMIN")) {

			Admin existAdmin = adminDao.findByEmail(login.getEmail());
			if (existAdmin == null)
				throw new LoginException("Please Enter a valid loginS");

			Optional<CurrentUserSession> validAdminSessionOpt = sessionDao.findById(existAdmin.getAdminId());

			if (validAdminSessionOpt.isPresent()) {

				throw new LoginException("Admin already Logged in");

			}

			// Check Admin Password

			if (existAdmin.getPassword().equals(login.getPassword())) {

				String key = UUID.randomUUID().toString();

				currentUserSession = new CurrentUserSession(existAdmin.getAdminId(), key, LocalDateTime.now(),
						login.getUser_Type());

				sessionDao.save(currentUserSession);

				return key;
			} else
				throw new LoginException("Passowrd incorrect");
		}

		if (login.getUser_Type().equals("OPERATOR")) {

			Operator existingOperator = operatorDao.findByEmail(login.getEmail());
			if (existingOperator == null)
				throw new LoginException("Please Enter a valid loginS");

			java.util.Optional<CurrentUserSession> validOperatorSessionOpt = sessionDao
					.findById(existingOperator.getOperatorId());

			if (validOperatorSessionOpt.isPresent()) {

				throw new LoginException("User already Logged In with this Email");

			}

			if (existingOperator.equals(login.getPassword())) {

				String key = UUID.randomUUID().toString();

				currentUserSession = new CurrentUserSession(existingOperator.getOperatorId(), key, LocalDateTime.now(),
						login.getUser_Type());

				sessionDao.save(currentUserSession);

				return key;
			} else
				throw new LoginException("Passowrd incorrect");
		} else
			throw new LoginException("Please Enter a valid User");
		
		
		
	}
	*/

	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sDao.delete(validCustomerSession);
		
		
		return "Logged Out !";
		
		
	}

}
