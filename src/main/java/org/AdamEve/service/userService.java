package org.AdamEve.service;

import java.util.List;

import org.AdamEve.object.profile;
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
	
}