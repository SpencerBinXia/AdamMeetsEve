package org.AdamEve.object;

import java.time.LocalDateTime;

public class profile{
	
	private String profileID;
	private String ssn;
	private int age;
	private int rangestart;
	private int rangeend;
	private int georange;
	private String malefemale;
	private String hobbies;
	private double height;
	private int weight;
	private String hairColor;
	private LocalDateTime createDate;
	private LocalDateTime lastModDate;
	
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRangestart() {
		return rangestart;
	}
	public void setRangestart(int rangestart) {
		this.rangestart = rangestart;
	}
	public int getRangeend() {
		return rangeend;
	}
	public void setRangeend(int rangeend) {
		this.rangeend = rangeend;
	}
	public int getGeorange() {
		return georange;
	}
	public void setGeorange(int georange) {
		this.georange = georange;
	}
	public String getMalefemale() {
		return malefemale;
	}
	public void setMalefemale(String malefemale) {
		this.malefemale = malefemale;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public LocalDateTime getLastModDate() {
		return lastModDate;
	}
	public void setLastModDate(LocalDateTime lastModDate) {
		this.lastModDate = lastModDate;
	}
	
}