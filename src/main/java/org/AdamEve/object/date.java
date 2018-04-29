package org.AdamEve.object;

import java.time.LocalDateTime;

public class date{
	
	private String profileID1;
	private String profileID2;
	private String custRep;
	private LocalDateTime dateTime;
	private String location;
	private int bookFee;
	private String comments;
	private int user1rate;
	private int user2rate;
	
	public String getProfileID1() {
		return profileID1;
	}
	public void setProfileID1(String profileID1) {
		this.profileID1 = profileID1;
	}
	public String getProfileID2() {
		return profileID2;
	}
	public void setProfileID2(String profileID2) {
		this.profileID2 = profileID2;
	}
	public String getCustRep() {
		return custRep;
	}
	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getBookFee() {
		return bookFee;
	}
	public void setBookFee(int bookFee) {
		this.bookFee = bookFee;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getUser1rate() {
		return user1rate;
	}
	public void setUser1rate(int user1rate) {
		this.user1rate = user1rate;
	}
	public int getUser2rate() {
		return user2rate;
	}
	public void setUser2rate(int user2rate) {
		this.user2rate = user2rate;
	}
	
}