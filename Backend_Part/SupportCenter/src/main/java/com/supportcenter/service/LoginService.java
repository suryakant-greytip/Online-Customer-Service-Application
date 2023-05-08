package com.supportcenter.service;

import javax.security.auth.login.LoginException;

import com.supportcenter.model.Login;

public interface LoginService {

public String loginUser(Login credential) throws LoginException;
	
	public String logoutUser (String Key) throws LoginException;

}
