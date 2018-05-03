package org.AdamEve.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.AdamEve.object.date;
import org.AdamEve.object.dateInfo;
import org.AdamEve.object.employee;
import org.AdamEve.object.employeeChangeInfo;
import org.AdamEve.object.likes;
import org.AdamEve.object.profile;
import org.AdamEve.object.profileInfo;
import org.AdamEve.object.referral;
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

	public List<profile> finduserProfiles(String ssn) {
		List<profile> profiles = userRepo.findProfilesbySSN(ssn);
		return profiles;
	}

	public List<profile> searchProfiles(searchInfo parameters){
		List<profile> profiles = userRepo.findProfilesbySearch(parameters);
		if (profiles == null)
		{
			profiles = new ArrayList<profile>();
		}
		return profiles;
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

	public List<employee> getEmployees() {
		return userRepo.getAllEmployees();
	}

	public List<profile> getAllProfiles() {
		return userRepo.getAllProfiles();
	}

	public void addLike(String liker, String likee) {
		userRepo.addLike(liker, likee);
	}

	public List<likes> likedBy(String profileID) {
		return userRepo.likedByUser(profileID);
	}

	public List<likes> likedTo(String profileID) {
		return userRepo.likesByUser(profileID);
	}
	
	public List<date> getallDates(String profileID){
		return userRepo.datebyProfileID(profileID);
	}
	
	public List<referral> getreferralByID(String profileID){
		return userRepo.referralbyProfileID(profileID);
	}

	public void addDate(dateInfo dateInfo) {
		userRepo.addDate(dateInfo);
	}

	public void addReferral(String Referee, String referTo, String profileID) {
		userRepo.addReferral(Referee, referTo, profileID);
	}

	
}