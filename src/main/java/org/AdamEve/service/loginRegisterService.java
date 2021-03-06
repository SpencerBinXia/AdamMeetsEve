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
		System.out.println(emailAddress);
		user newuser = repository.findUserByEmail(emailAddress);
		System.out.println(newuser.getSsn());
		String password = info.getPassword();
		if (newuser != null) {
			user validUser = newuser;
			if (password.equals(validUser.getPassword()))
			{;
				System.out.println(validUser.getSsn());
				session.setAttribute("currentUser", validUser);
				session.setAttribute("foundUser", validUser);

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
			newuser.setZipcode(info.getZipcode());
			newuser.setppp(info.getppp());
			newuser.setRating(0);
			newuser.setccard(info.getccard());
			newuser.setLastAct(LocalDateTime.now());
			repository.addUser(newuser, info.getccard());
			session.setAttribute("currentUser", newuser);
			return true;
		}
		
		return false;
	}

	public boolean isEmployee(String ssn) {
		return repository.isEmployee(ssn);
	}

}