package org.AdamEve.repository;

import org.AdamEve.object.employee;
import org.AdamEve.object.likes;
import org.AdamEve.object.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class userrepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public user findUserByEmail(String emailAddress) {
		String selectEmail = "SELECT * FROM Person WHERE Email='" + emailAddress + "';";
		user tempuser = new user();
		try {
			jdbcTemplate.queryForObject(selectEmail, new RowMapper<user>() {
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
					return tempuser;
				}
			});
		}
		catch (Exception e)
		{
			return null;
		}
		return tempuser;
	}

	public user findBySsn(String ssn) {
		String selectEmail = "SELECT * FROM Person WHERE SSN='" + ssn + "';";
	    user tempuser = new user();
	    try {
			jdbcTemplate.queryForObject(selectEmail, new RowMapper<user>() {
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
					return tempuser;
				}
			});
		}
		catch (Exception e)
		{
			return null;
		}
        return tempuser;
	}

	public void addUser(user newuser) {
        jdbcTemplate.update("INSERT INTO Person(SSN, Password, FirstName, LastName, Street, City, State, Zipcode, Email, Telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                newuser.getSsn(), newuser.getPassword(),newuser.getFirstName(),newuser.getLastName(),newuser.getStreet(),newuser.getCity(),newuser.getState(),
                newuser.getZipcode(),newuser.getEmail(),newuser.getTelephone());
        jdbcTemplate.update("INSERT INTO User(SSN,PPP,Rating,DateOfLastAct)" + "VALUES (?, ?, ?, ?)",
                newuser.getSsn(), newuser.getPpp(), newuser.getRating(),newuser.getLastAct());
		
	}
	
	
	public boolean isManager(String ssn) {
		String selectEmail = "SELECT * FROM Employee WHERE SSN='" + ssn + "';";
		employee tempemployee = new employee();
		jdbcTemplate.queryForObject(selectEmail, new RowMapper<employee>(){
	        public employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            tempemployee.setRole(rs.getString("Role"));
	            tempemployee.setSsn(rs.getString("Ssn"));
	            tempemployee.setStartDate(rs.getDate("StartDate"));
	            tempemployee.setHourlyRate(rs.getInt("HourlyRate"));
	            return tempemployee;
            }
        });
		if (tempemployee.getRole().equals("Manager")){
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<likes> likedByUser(String ProfileID){
		String selectLiked = "SELECT * FROM Likes WHERE Liker='" + ProfileID + "';";
		List<likes> liked = new ArrayList<likes>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectLiked);
		for (Map row : rows) {
			likes like = new likes();
			like.setLiker((String)row.get("Liker"));
			like.setLikee((String)row.get("Likee"));
			like.setTimeLike((LocalDateTime)row.get("Date_Time"));
			liked.add(like);
		}
		
		return liked;
		
	}
	
	public List<likes> likesByUser(String ProfileID){
		String selectLikes = "SELECT * FROM Likes WHERE Likee='" + ProfileID + "';";
		List<likes> likes = new ArrayList<likes>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectLikes);
		for (Map row : rows) {
			likes like = new likes();
			like.setLiker((String)row.get("Liker"));
			like.setLikee((String)row.get("Likee"));
			like.setTimeLike((LocalDateTime)row.get("Date_Time"));
			likes.add(like);
		}
		
		return likes;
		
	}

}