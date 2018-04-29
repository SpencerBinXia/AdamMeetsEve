package org.AdamEve.object;

import java.time.LocalDateTime;

public class suggestion{
	
	private String custRep;
	private String profileID1;
	private String profileID2;
	private LocalDateTime suggestedDate;
	
	public String getCustRep() {
		return custRep;
	}
	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}
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
	public LocalDateTime getSuggestedDate() {
		return suggestedDate;
	}
	public void setSuggestedDate(LocalDateTime suggestedDate) {
		this.suggestedDate = suggestedDate;
	}
	
}