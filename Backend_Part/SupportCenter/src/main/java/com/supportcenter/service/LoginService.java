package com.supportcenter.service;

import javax.security.auth.login.LoginException;

import com.supportcenter.model.LoginDTO;

public interface LoginService {

public String logIntoAccount(LoginDTO credential) throws LoginException;
	
	public String logOutFromAccount (String Key) throws LoginException;

}
