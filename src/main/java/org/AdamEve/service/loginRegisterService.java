package org.AdamEve.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.AdamEve.object.loginInfo;
import org.AdamEve.object.registerInfo;
import org.AdamEve.object.user;
//import org.AdamEve.object.registerInfo;
//import org.AdamEve.object.user;
import org.AdamEve.repository.userrepository;

@Service
public class  loginRegisterService {
	
	@Autowired
	private userrepository repository;

	public boolean loginUser(loginInfo info, HttpSession session) {
		String emailAddress = info.getEmail();
		user user = repository.findUserByEmail(emailAddress);
		String password = info.getPassword();
		if (user != null) {
			user validUser = user;
			if (password.equals(validUser.getPassword()))
			{
				session.setAttribute("currentUser", validUser);
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;		

	}

	public boolean registerUser(registerInfo info, HttpSession session) {
		long conflict = repository.checkSSN(info.getSsn());
		
		
		return false;
	}

}