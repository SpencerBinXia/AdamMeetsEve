package org.AdamEve.repository;

import org.AdamEve.object.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class userrepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean registerUser() {


		
		return true;
	}

	public user findUserByEmail(String emailAddress) {
	    String selectEmail = "SELECT * FROM Person WHERE Email='" + emailAddress + "';";
	    user tempuser = new user();
	    jdbcTemplate.queryForObject(selectEmail, new RowMapper<user>(){
	        public user mapRow(ResultSet rs, int rowNum) throws SQLException {
	            tempuser.setEmail(rs.getString("Email"));
	            tempuser.setSsn(rs.getString("Ssn"));
	            tempuser.setPassword(rs.getString("Password"));
	            tempuser.setFirstName(rs.getString("FirstName"));
	            tempuser.setLastName(rs.getString("LastName"));
	            tempuser.setStreet(rs.getString("Street"));
	            tempuser.setCity(rs.getString("City"));
	            tempuser.setState(rs.getString("State"));
	            tempuser.setZipcode(rs.getInt("Zipcode"));
	            tempuser.setTelephone(rs.getString("Telephone"));
	            System.out.println(tempuser.getSsn());
	            return tempuser;
            }
        });

		// TODO Auto-generated method stub
        return tempuser;
	}

	public user findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(user newuser) {
        jdbcTemplate.update("INSERT INTO Person(SSN, Password, FirstName, LastName, Street, City, State, Zipcode, Email, Telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                newuser.getSsn(), newuser.getPassword(),newuser.getFirstName(),newuser.getLastName(),newuser.getStreet(),newuser.getCity(),newuser.getState(),
                newuser.getZipcode(),newuser.getEmail(),newuser.getTelephone());
        jdbcTemplate.update("INSERT INTO User(SSN,PPP,Rating,DateOfLastAct)" + "VALUES (?, ?, ?, ?)",
                newuser.getSsn(), newuser.getPpp(), newuser.getRating(),newuser.getLastAct());
		
	}

}