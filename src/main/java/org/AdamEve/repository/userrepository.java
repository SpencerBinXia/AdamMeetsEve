package org.AdamEve.repository;

import org.AdamEve.object.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class userrepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean registerUser() {

		//jdbcTemplate.update("INSERT INTO tablename(column1, column2) VALUES (?, ?)", var1, var2);
		
		return true;
	}

	public user findUserByEmail(String emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	public user findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(user newuser) {
		// TODO Auto-generated method stub
		
	}

}