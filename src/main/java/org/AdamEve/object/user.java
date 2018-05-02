package org.AdamEve.object;

import java.time.LocalDateTime;

public class user {
	
	private String ssn;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private String telephone;
	private String ppp;
	private int rating;
	private LocalDateTime lastAct;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPpp() {
		return ppp;
	}
	public void setPpp(String ppp) {
		this.ppp = ppp;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public LocalDateTime getLastAct() {
		return lastAct;
	}
	public void setLastAct(LocalDateTime lastAct) {
		this.lastAct = lastAct;
	}
	
}