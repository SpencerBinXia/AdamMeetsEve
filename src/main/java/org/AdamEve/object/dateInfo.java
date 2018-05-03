package org.AdamEve.object;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateInfo{
	
	private String profileID1;
	private String profileID2;
	private int rating1;
	private int rating2;
	private String comments;
	private String custRep;
	private LocalDateTime dateTime;
	private String location;
	private int bookFee;
	
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public int getRating1(){return rating1;}
	public void setRating1(int rating1){
		this.rating1 = rating1;
	}
	public int getRating2(){return rating2;}
	public void setRating2(int rating2){
		this.rating2 = rating1;
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
	
}