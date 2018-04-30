package org.AdamEve.service;

import java.time.LocalDateTime;

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
		user newuser = repository.findUserByEmail(emailAddress);
		String password = info.getPassword();
		if (newuser != null) {
			user validUser = newuser;
			if (password.equals(validUser.getPassword()))
			{;
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
		user existing = repository.findBySsn(info.getSsn());
		if (existing == null) {
			user newuser = new user();
			newuser.setSsn(info.getSsn());
			newuser.setEmail(info.getEmail());
			newuser.setPassword(info.getPassword());
			newuser.setFirstName(info.getFirstName());
			newuser.setLastName(info.getLastName());
			newuser.setStreet(info.getStreet());
			newuser.setCity(info.getCity());
			newuser.setState(info.getState());
			newuser.setTelephone(info.getTelephone());
			newuser.setPpp(1);
			newuser.setRating(0);
			newuser.setLastAct(LocalDateTime.now());
			repository.addUser(newuser);
			return true;
		}
		
		return false;
	}

}