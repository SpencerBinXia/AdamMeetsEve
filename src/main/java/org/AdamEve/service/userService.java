package org.AdamEve.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.employee;
import org.AdamEve.object.employeeChangeInfo;
import org.AdamEve.object.profile;
import org.AdamEve.object.profileInfo;
import org.AdamEve.object.registerInfo;
import org.AdamEve.object.searchInfo;
import org.AdamEve.object.user;
import org.AdamEve.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
	
	@Autowired
	private userrepository userRepo;
	
	public user findUser(String id){
		user user = userRepo.findBySsn(id);
		return user;
	}

	public profile findProfile(String profileID) {
		profile profile = userRepo.findProfilebyID(profileID);
		return profile;
	}
	
	public List<profile> searchProfiles(searchInfo parameters){
		return null;
	}

	public void changeUserInfo(registerInfo reginfo, HttpSession session) {
		userRepo.updateUser(reginfo);
	}

	public void createProfile(profileInfo profileInfo) {
		userRepo.addProfile(profileInfo);
	}

	public employee findEmployee(String employeeid) {
		employee employee = userRepo.findEmployeeBySsn(employeeid);
		return employee;
	}

	public void changeEmployeeInfo(employeeChangeInfo employeeinfo, HttpSession session) {
		userRepo.updateEmployee(employeeinfo);
	}
	
}