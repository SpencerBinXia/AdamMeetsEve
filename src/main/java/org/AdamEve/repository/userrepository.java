package org.AdamEve.repository;

import org.AdamEve.object.employee;
import org.AdamEve.object.likes;
import org.AdamEve.object.profile;
import org.AdamEve.object.profileInfo;
import org.AdamEve.object.registerInfo;
import org.AdamEve.object.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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
		String selectSsn = "SELECT * FROM Person WHERE SSN='" + ssn + "';";
	    user tempuser = new user();
	    try {
			jdbcTemplate.queryForObject(selectSsn, new RowMapper<user>() {
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
	
	public List<profile> searchByPPP(int PPP){
		String selectSSN = "SELECT * FROM User WHERE PPP='" + PPP + "';";
		List<Integer> userssn = new ArrayList<Integer>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectSSN);
		for (Map row : rows) {
			userssn.add((int)row.get("Ssn"));
		}
		List<profile> profiles = new ArrayList<profile>();
		for (int ssn : userssn) {
			String selectProfiles = "SELECT * FROM Profile WHERE SSN='" + ssn + "';";
			rows = jdbcTemplate.queryForList(selectProfiles);
			for (Map row : rows) {
				profile tempprofile = new profile();
				tempprofile.setProfileID((String)row.get("ProfileID"));
				tempprofile.setSsn((String)row.get("OwnerSSN"));
				tempprofile.setAge((int)row.get("Age"));
				tempprofile.setRangestart((int)row.get("DatingAgeRangeStart"));
				tempprofile.setRangeend((int)row.get("DatingAgeRangeEnd"));
				tempprofile.setGeorange((int)row.get("DatingGeoRange"));
				tempprofile.setMalefemale((String)row.get("M_F"));
				tempprofile.setHobbies((String)row.get("Hobbies"));
				tempprofile.setHeight((int)row.get("Height"));
				tempprofile.setWeight((int)row.get("Weight"));
				tempprofile.setHairColor((String)row.get("HairColor"));
				tempprofile.setCreateDate((LocalDateTime)row.get("CreationDate"));
				tempprofile.setLastModDate((LocalDateTime)row.get("LastModDate"));
				profiles.add(tempprofile);
			}
		}
		
		return profiles;
		
	}

	public void addUser(user newuser, String ccard) {
        jdbcTemplate.update("INSERT INTO Person(SSN, Password, FirstName, LastName, Street, City, State, Zipcode, Email, Telephone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                newuser.getSsn(), newuser.getPassword(),newuser.getFirstName(),newuser.getLastName(),newuser.getStreet(),newuser.getCity(),newuser.getState(),
                newuser.getZipcode(),newuser.getEmail(),newuser.getTelephone());
        jdbcTemplate.update("INSERT INTO User(SSN,PPP,Rating,DateOfLastAct)" + "VALUES (?, ?, ?, ?)",
                newuser.getSsn(), newuser.getPpp(), newuser.getRating(),newuser.getLastAct());
        String getMax = "SELECT MAX(INT(acctnum)) FROM Account";
        Integer acctnum = jdbcTemplate.queryForObject(getMax, Integer.class) + 1;
        jdbcTemplate.update("INSERT INTO Account(OwnerSSN, CardNumber, AcctNum, AcctCreationDate)" + 
                	"VALUES (?,?,?,?)",
                	newuser.getSsn(), ccard, acctnum.toString(), newuser.getLastAct());
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
	
	public profile findProfilebyID(String ProfileID) {
		String selectProfile = "SELECT * FROM Profile WHERE ProfileID='" + ProfileID + "';";
	    profile tempprofile = new profile();
	    try {
			jdbcTemplate.queryForObject(selectProfile, new RowMapper<profile>() {
				public profile mapRow(ResultSet rs, int rowNum) throws SQLException {
					tempprofile.setProfileID(rs.getString("ProfileID"));
					tempprofile.setSsn(rs.getString("OwnerSSN"));
					tempprofile.setAge(rs.getInt("Age"));
					tempprofile.setRangestart(rs.getInt("DatingAgeRangeStart"));
					tempprofile.setRangeend(rs.getInt("DatingAgeRangeEnd"));
					tempprofile.setGeorange(rs.getInt("DatingGeoRange"));
					tempprofile.setMalefemale(rs.getString("M_F"));
					tempprofile.setHobbies(rs.getString("Hobbies"));
					tempprofile.setHeight(rs.getInt("Height"));
					tempprofile.setWeight(rs.getInt("Weight"));
					tempprofile.setHairColor(rs.getString("HairColor"));
					tempprofile.setCreateDate((LocalDateTime)rs.getObject("CreationDate"));
					tempprofile.setLastModDate((LocalDateTime)rs.getObject("LastModDate"));
					return tempprofile;
				}
			});
		}
		catch (Exception e)
		{
			return null;
		}
        return tempprofile;
	}

	public void updateUser(registerInfo reginfo) {
		jdbcTemplate.update("update Person set Password = ?, FirstName = ?, LastName= ?, Street= ?, City = ?, State= ?, Zipcode=? Email=? Telephone=?" + 
				"where SSN= ?",
        reginfo.getPassword(),reginfo.getFirstName(),reginfo.getLastName(),reginfo.getStreet(),reginfo.getCity(),reginfo.getState(),
        reginfo.getZipcode(),reginfo.getEmail(),reginfo.getTelephone(), reginfo.getSsn());
		jdbcTemplate.update("update User set PPP = ?, where SSN = ?", reginfo.getppp(), reginfo.getSsn());
		jdbcTemplate.update("update Account set CardNumber = ? where SSN = ?", reginfo.getccard(), reginfo.getSsn());
	}

	public void addProfile(profileInfo profileInfo) {
		jdbcTemplate.update("INSERT INTO Profile(ProfileID, OwnerSSN, Age, DatingAgeRangeStart, DatingAgeRangeEnd, DatingGeoRange, M_F, Hobbies, Height, Weight, HairColor, CreationDate, LastModDate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                profileInfo.getProfileID(), profileInfo.getOwnerSSN(), profileInfo.getAge(), profileInfo.getRangeStart(), profileInfo.getRangeEnd(), profileInfo.getGeoRange(), profileInfo.getGender(),
                profileInfo.getHobbies(), profileInfo.getHeight(), profileInfo.getWeight(), profileInfo.getHairColor(), LocalDateTime.now(), LocalDateTime.now());	
	}

	public employee findEmployeeBySsn(String employeeid) {
		String selectSsn = "SELECT * FROM Person WHERE SSN='" + employeeid + "';";
	    employee tempemployee = new employee();
	    try {
			jdbcTemplate.queryForObject(selectSsn, new RowMapper<employee>() {
				public employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					tempemployee.setSsn(rs.getString("SSN"));
					tempemployee.setRole(rs.getString("Role"));
					tempemployee.setStartDate((Date)rs.getObject("StartDate"));
					tempemployee.setHourlyRate(rs.getInt("HourlyRate"));
					return tempemployee;
				}
			});
		}
		catch (Exception e)
		{
			return null;
		}
        return tempemployee;
	}

}