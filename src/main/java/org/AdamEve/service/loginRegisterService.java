package org.AdamEve.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.AdamEve.object.loginInfo;
import org.AdamEve.repository.userrepository;

@Service
public class loginRegisterService {
	
	@Autowired
	private userrepository repository;
	
	public boolean loginUser(loginInfo info, HttpSession model) {
		
		return true;
	}
	
}