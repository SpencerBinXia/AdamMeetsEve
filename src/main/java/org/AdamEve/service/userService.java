package org.AdamEve.service;

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
	
	
}