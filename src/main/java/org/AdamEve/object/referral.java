package org.AdamEve.object;

import java.time.LocalDateTime;

public class referral{
	
	private String profileID1;
	private String profileID2;
	private String profileID3;
	private LocalDateTime referredDate;
	
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
	public String getProfileID3() {
		return profileID3;
	}
	public void setProfileID3(String profileID3) {
		this.profileID3 = profileID3;
	}
	public LocalDateTime getReferredDate() {
		return referredDate;
	}
	public void setReferredDate(LocalDateTime referredDate) {
		this.referredDate = referredDate;
	}
	
}