package org.AdamEve.repository;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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

			String selectPPP = "SELECT * FROM User WHERE SSN='" + tempuser.getSsn() + "';";
			String selectCcard = "SELECT * FROM Account WHERE OwnerSSN='" + tempuser.getSsn() + "';";


			jdbcTemplate.queryForObject(selectPPP, new RowMapper<user>(){
				public user mapRow(ResultSet rs, int rowNum) throws SQLException {
					tempuser.setppp(rs.getString("PPP"));
					return tempuser;
				}
			});
			jdbcTemplate.queryForObject(selectCcard, new RowMapper<user>(){
				public user mapRow(ResultSet rs, int rowNum) throws SQLException {
					tempuser.setccard(rs.getString("CardNumber"));
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
		String selectPPP = "SELECT * FROM User WHERE SSN='" + ssn + "';";
		String selectCcard = "SELECT * FROM Account WHERE OwnerSSN='" + ssn + "';";
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

			jdbcTemplate.queryForObject(selectPPP, new RowMapper<user>(){
				public user mapRow(ResultSet rs, int rowNum) throws SQLException {
					tempuser.setppp(rs.getString("PPP"));
					return tempuser;
				}
			});

			jdbcTemplate.queryForObject(selectCcard, new RowMapper<user>(){
				public user mapRow(ResultSet rs, int rowNum) throws SQLException {
					tempuser.setccard(rs.getString("CardNumber"));
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

	public List<profile> findProfilesbySSN(String ssn){
		String selectProfiles = "SELECT * FROM Profile WHERE OwnerSSN='" + ssn + "';";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectProfiles);
		List<profile> profiles = new ArrayList<profile>();
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
			tempprofile.setHeight((double)row.get("Height"));
			tempprofile.setWeight((int)row.get("Weight"));
			tempprofile.setHairColor((String)row.get("HairColor"));
			tempprofile.setCreateDate(((Timestamp)row.get("CreationDate")).toLocalDateTime());
			tempprofile.setLastModDate(((Timestamp)row.get("LastModDate")).toLocalDateTime());
			profiles.add(tempprofile);
		}
		return profiles;

	}
	
	public profile findProfilesbyID(String profileID){
		String selectProfile = "SELECT * FROM Profile WHERE ProfileID='" + profileID + "';";
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
					tempprofile.setHeight(rs.getDouble("Height"));
					tempprofile.setWeight(rs.getInt("Weight"));
					tempprofile.setHairColor(rs.getString("HairColor"));
					tempprofile.setCreateDate(((Timestamp)rs.getObject("CreationDate")).toLocalDateTime());
					tempprofile.setLastModDate(((Timestamp)rs.getObject("LastModDate")).toLocalDateTime());
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
	
	public List<profile> findProfilesbySearch(searchInfo parameters){
		List<List<String>> allsearchresults = new ArrayList<List<String>>();
		if (parameters.getAgeStart() > 0) {
			String selectAgeStart = "SELECT * FROM Profile WHERE Age>=" + parameters.getAgeStart() + ";";
			List<String> inAgeStart = new ArrayList<String>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectAgeStart);
			for (Map row : rows) {
				inAgeStart.add((String)row.get("ProfileID"));
			}
			allsearchresults.add(inAgeStart);
		}
		if (parameters.getAgeEnd() > 0) {
			String selectAgeEnd = "SELECT * FROM Profile WHERE Age<=" + parameters.getAgeEnd() + ";";
			List<String> inAgeEnd = new ArrayList<String>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectAgeEnd);
			for (Map row : rows) {
				inAgeEnd.add((String)row.get("ProfileID"));
			}
			allsearchresults.add(inAgeEnd);
		}
		if (! (parameters.getGender().equals("") )) {
			String selectGender = "SELECT * FROM Profile WHERE M_F='" + parameters.getGender() + "';";
			List<String> inGender = new ArrayList<String>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectGender);
			for (Map row : rows) {
				inGender.add((String)row.get("ProfileID"));
			}
			allsearchresults.add(inGender);
		}
		System.out.println(parameters.getHeightstart());
		if (parameters.getHeightstart() > 0) {
			String selectHeightStart = "SELECT * FROM" + " Profile WHERE Height>=" + parameters.getHeightstart() + ";";
			List<String> inHeightStart = new ArrayList<String>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectHeightStart);
			for (Map row : rows) {
				inHeightStart.add((String)row.get("ProfileID"));
			}
			allsearchresults.add(inHeightStart);
		}
		if (parameters.getHeightend() > 0) {
			String selectHeightEnd = "SELECT * FROM Profile WHERE Height<=" + parameters.getHeightend() + ";";
			List<String> inHeightEnd = new ArrayList<String>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectHeightEnd);
			for (Map row : rows) {
				inHeightEnd.add((String)row.get("ProfileID"));
			}
			allsearchresults.add(inHeightEnd);
		}
		if (parameters.getWeightstart() > 0) {
			String selectWeightStart = "SELECT * FROM Profile WHERE Weight>=" + parameters.getWeightstart() + ";";
			List<String> inWeightStart = new ArrayList<String>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectWeightStart);
			for (Map row : rows) {
				inWeightStart.add((String)row.get("ProfileID"));
			}
			allsearchresults.add(inWeightStart);
		}
		if (parameters.getWeightend() > 0) {
			String selectWeightEnd = "SELECT * FROM Profile WHERE Weight<=" + parameters.getWeightend() + ";";
			List<String> inWeightEnd = new ArrayList<String>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectWeightEnd);
			for (Map row : rows) {
				inWeightEnd.add((String)row.get("ProfileID"));
			}
			allsearchresults.add(inWeightEnd);
		}
		if (!(parameters.getHairColor().equals(""))) {
			String selectHairColor = "SELECT * FROM Profile WHERE HairColor='" + parameters.getHairColor() + "';";
			List<String> inHairColor = new ArrayList<String>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectHairColor);
			for (Map row : rows) {
				inHairColor.add((String)row.get("ProfileID"));
			}
			allsearchresults.add(inHairColor);
		}
		if (allsearchresults.isEmpty()){
			return null;
		}
		else {
			List<profile> finalreturn = new ArrayList<profile>();
			List<String> first = allsearchresults.get(0);
			for (String profileID : first) {
				boolean toAdd = true;
				for (List<String> inOrder : allsearchresults) {
					if (!(inOrder.contains(profileID))){
						toAdd = false;
					}
				}
				if (toAdd) {
					System.out.println(profileID);
					finalreturn.add(findProfilebyID(profileID));
				}
			}

			return finalreturn;
		}
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
			String selectProfiles = "SELECT * FROM Profile WHERE OwnerSSN='" + ssn + "';";
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
				tempprofile.setHeight((double)row.get("Height"));
				tempprofile.setWeight((int)row.get("Weight"));
				tempprofile.setHairColor((String)row.get("HairColor"));
				tempprofile.setCreateDate(((Timestamp)row.get("CreationDate")).toLocalDateTime());
				tempprofile.setLastModDate(((Timestamp)row.get("LastModDate")).toLocalDateTime());
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
                newuser.getSsn(), newuser.getppp(), newuser.getRating(),newuser.getLastAct());
        String getMax = "SELECT MAX(AcctNum) FROM Account";
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
			like.setTimeLike(((Timestamp)row.get("Date_Time")).toLocalDateTime());
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
			like.setTimeLike(((Timestamp)row.get("Date_Time")).toLocalDateTime());
			likes.add(like);
		}
		
		return likes;
		
	}
	
	public List<date> datebyProfileID(String ProfileID){
		String selectdates = "SELECT * FROM Date WHERE Profile1='" + ProfileID +
				"' OR Profile2='" + ProfileID + "';";
		List<date> dates = new ArrayList<date>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectdates);
		for (Map row : rows) {
			date date = new date();
			date.setProfileID1((String)row.get("Profile1"));
			date.setProfileID2((String)row.get("Profile2"));
			date.setCustRep((String)row.get("CustRep"));
			date.setDateTime(((Timestamp)row.get("Date_Time")).toLocalDateTime());
			date.setLocation((String)row.get("Location"));
			date.setBookFee((int)row.get("BookingFee"));
			date.setComments((String)row.get("Comments"));
			date.setUser1rate((int)row.get("User1Rating"));
			date.setUser2rate((int)row.get("User2Rating"));
			dates.add(date);
		}
		
		return dates;
	}
	
	public List<referral> referralbyProfileID(String ProfileID){
		String selectreferrals = "SELECT * FROM Referral WHERE ProfileB='" + ProfileID + "';";
		List<referral> referrals = new ArrayList<referral>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectreferrals);
		for (Map row : rows) {
			referral referral = new referral();
			referral.setProfileID1((String)row.get("ProfileA"));
			referral.setProfileID2((String)row.get("ProfileB"));
			referral.setProfileID3((String)row.get("ProfileC"));
			referral.setReferredDate(((Timestamp)row.get("Date_Time")).toLocalDateTime());;
			referrals.add(referral);
		}
		
		return referrals;
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
					tempprofile.setHeight(rs.getDouble("Height"));
					tempprofile.setWeight(rs.getInt("Weight"));
					tempprofile.setHairColor(rs.getString("HairColor"));
					tempprofile.setCreateDate(((Timestamp)rs.getObject("CreationDate")).toLocalDateTime());
					tempprofile.setLastModDate(((Timestamp)rs.getObject("LastModDate")).toLocalDateTime());
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

	public profile findProfilebySSN(String ssn) {
		String selectProfile = "SELECT * FROM Profile WHERE OwnerSSN='" + ssn + "';";
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
					tempprofile.setHeight(rs.getDouble("Height"));
					tempprofile.setWeight(rs.getInt("Weight"));
					tempprofile.setHairColor(rs.getString("HairColor"));
					tempprofile.setCreateDate(((Timestamp)rs.getObject("CreationDate")).toLocalDateTime());
					tempprofile.setLastModDate(((Timestamp)rs.getObject("LastModDate")).toLocalDateTime());					tempprofile.setLastModDate((LocalDateTime)rs.getObject("LastModDate"));
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
		jdbcTemplate.update("update Person set Password = ?, FirstName = ?, LastName= ?, Street= ?, City = ?, State= ?, Zipcode=?, Email=?, Telephone=?" +
				"where SSN= ?",
        reginfo.getPassword(),reginfo.getFirstName(),reginfo.getLastName(),reginfo.getStreet(),reginfo.getCity(),reginfo.getState(),
        reginfo.getZipcode(),reginfo.getEmail(),reginfo.getTelephone(), reginfo.getSsn());
		jdbcTemplate.update("update User set PPP = ? where SSN = ?", reginfo.getppp(), reginfo.getSsn());
		jdbcTemplate.update("update Account set CardNumber = ? where OwnerSSN = ?", reginfo.getccard(), reginfo.getSsn());
	}

	public void updateProfile(profileInfo profinfo) {
		jdbcTemplate.update("update Profile set Age = ?, DatingAgeRangeStart = ?, DatingAgeRangeEnd = ?, DatingGeoRange = ?, Height = ?, Weight =?, HairColor=?, Hobbies=?" +
						"where ProfileID= ?",
				profinfo.getAge(),profinfo.getRangeStart(),profinfo.getRangeEnd(),profinfo.getGeoRange(), profinfo.getHeight(),
				profinfo.getWeight(),profinfo.getHairColor(),profinfo.getHobbies(), profinfo.getProfileID());
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

	public void updateEmployee(employeeChangeInfo employeeinfo) {
		
		jdbcTemplate.update("update Person set Password = ?, FirstName = ?, LastName= ?, Street= ?, City = ?, State= ?, Zipcode=? Email=? Telephone=?" + 
				"where SSN= ?",
        employeeinfo.getPassword(),employeeinfo.getFirstName(),employeeinfo.getLastName(),employeeinfo.getStreet(),employeeinfo.getCity(),employeeinfo.getState(),
        employeeinfo.getZipcode(),employeeinfo.getEmail(),employeeinfo.getTelephone(), employeeinfo.getSsn());
		jdbcTemplate.update("update Employee set Role = ?, HourlyRate= ? where SSN = ?", employeeinfo.getRole(), employeeinfo.getHourlyRate(), employeeinfo.getSsn());
	}

	public List<employee> getAllEmployees() {
		String selectEmployee = "SELECT * FROM Employee;";
		List<employee> Employees = new ArrayList<employee>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectEmployee);
		for (Map row : rows) {
			employee newemployee = new employee();
			newemployee.setSsn((String)row.get("SSN"));
			newemployee.setRole((String)row.get("Role"));
			newemployee.setStartDate((Date)row.get("StartDate"));
			newemployee.setHourlyRate((int)row.get("HourlyRate"));
			Employees.add(newemployee);
		}
		
		return Employees;
	}

	public List<profile> getAllProfiles() {
		String selectProfiles = "SELECT * FROM Profile;";
		List<profile> Profiles = new ArrayList<profile>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectProfiles);
		for (Map row : rows) {
			profile newprofile = new profile();
			newprofile.setProfileID((String)row.get("ProfileID"));
			newprofile.setSsn((String)row.get("OwnerSSN"));
			newprofile.setAge((int)row.get("Age"));
			newprofile.setRangestart((int)row.get("DatingAgeRangeStart"));
			newprofile.setRangeend((int)row.get("DatingAgeRangeEnd"));
			newprofile.setGeorange((int)row.get("DatingGeoRange"));
			newprofile.setMalefemale((String)row.get("M_F"));
			newprofile.setHobbies((String)row.get("Hobbies"));
			newprofile.setHeight((double)row.get("Height"));
			newprofile.setWeight((int)row.get("Weight"));
			newprofile.setHairColor((String)row.get("HairColor"));
			newprofile.setCreateDate(((Timestamp)row.get("CreationDate")).toLocalDateTime());
			newprofile.setLastModDate(((Timestamp)row.get("LastModDate")).toLocalDateTime());
			Profiles.add(newprofile);
		}
		
		return Profiles;
	}

	public boolean isEmployee(String ssn) {
		String selectEmployees = "SELECT * FROM Employee";
		List<String> employeeSSN = new ArrayList<String>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(selectEmployees);
		for (Map row : rows) {
			employeeSSN.add((String)row.get("SSN"));
		}
		if (employeeSSN.contains(ssn)) {
			return true;
		}
		return false;
	}

	public void addLike(String liker, String likee) {
		jdbcTemplate.update("INSERT INTO Likes(Liker, Likee, Date_Time)" +
				"VALUES (?, ?, ?)",
				liker, likee, LocalDateTime.now());
	}

	public void addDate(dateInfo dateInfo) {
		LocalDateTime dateTime = LocalDateTime.now();
		int tempRating2 = 0;
		jdbcTemplate.update("INSERT INTO Date(Profile1, Profile2, Date_Time, Location, BookingFee, User1Rating, User2Rating, Comments)" +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				dateInfo.getProfileID1(), dateInfo.getProfileID2(), 
				dateTime, dateInfo.getLocation(), dateInfo.getBookFee(), dateInfo.getRating1(), dateInfo.getRating2(), dateInfo.getComments());
	}

	public void addReferral(String referee, String referTo, String profileID) {
		jdbcTemplate.update("INSERT INTO Referral(ProfileA, ProfileB, ProfileC, Date_Time)" + 
				"VALUES (?, ?, ?, ?)",
				referee, referTo, profileID, LocalDateTime.now());	
		
	}	
	

}