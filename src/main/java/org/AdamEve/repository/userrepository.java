package org.AdamEve.repository;

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
	
}